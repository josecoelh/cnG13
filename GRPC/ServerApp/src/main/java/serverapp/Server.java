package serverapp;

import com.google.protobuf.Empty;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import services.*;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Server extends ServiceGrpc.ServiceImplBase {

    private static int svcPort = 8000;
    private static UserOperations userOps;
    private static ImageRepository imgRepo;
    private static OCRPublisher ocrHandler;
    private static ConcurrentLinkedQueue<String> sessionQueue = new ConcurrentLinkedQueue<>();
    private static final Object monitor = new Object();


    public static void main(String[] args) {
        try {
            if (args.length > 0) svcPort = Integer.parseInt(args[0]);
            io.grpc.Server svc = ServerBuilder
                    .forPort(svcPort)
                    .addService(new Server())
                    .build();
            svc.start();
            userOps = new UserOperations();
            imgRepo = new ImageRepository();
            ocrHandler = new OCRPublisher();




            System.out.println("Server started, listening on " + svcPort);
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            svc.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Sends a response to the client after verifying if given user exists and the account type is correct
     * might return bad SessionId if user is already loggedIn
     * */
    @Override
    public void login(ProtoUser protoUser, StreamObserver<SessionId> responseObserver) {
        synchronized (monitor) {
            ProtoUser user = userOps.login(protoUser);
            SessionId sessionId;
            if (user != null && sessionQueue.contains(user.getUsername())) {
                responseObserver.onNext(SessionId.newBuilder().setAlreadyLoggedIn(true).build());
                responseObserver.onCompleted();
                return;
            }
            if (user == null) {
                sessionId = SessionId.newBuilder().setCredentials(false).setAlreadyLoggedIn(false).build();
            } else {
                sessionId = SessionId.newBuilder().setId(user.getUsername())
                        .setIsPremium(user.getAccountType().equals("Premium"))
                        .setCredentials(true)
                        .setAlreadyLoggedIn(false).build();
                sessionQueue.add(user.getUsername());
            }
            responseObserver.onNext(sessionId);
            responseObserver.onCompleted();
        }
    }

    /*
     * removes the user from the sessionQueue and notifies the client*/
    @Override
    public void close(SessionId request, StreamObserver<Empty> responseObserver) {
        synchronized (monitor) {
            sessionQueue.remove(request.getId());
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void sendImage(Image request, StreamObserver<ImageId> responseObserver) {
        ImageId response = imgRepo.uploadImage(request);
        if (!response.getFailed()) userOps.addUserImg(request.getUser().getId(), request.getImageName());
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void listUserImages(SessionId request, StreamObserver<UserImages> responseObserver) {
        UserImages userImages = userOps.listUserImages(request.getId());
        responseObserver.onNext(userImages);
        responseObserver.onCompleted();
    }

    @Override
    public void requestOCR(OCRequest request, StreamObserver<Empty> responseObserver) {
        try {
            userOps.removeUserImg(request.getUser().getId(),request.getImageId());
            ocrHandler.publishRequest(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    public void requestOCResult(OCRequest request, StreamObserver<OCReply> responseObserver) {
        String res = ResultDB.getText(request.getImageId());
        OCReply reply = OCReply.newBuilder().setResult(res).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


}
