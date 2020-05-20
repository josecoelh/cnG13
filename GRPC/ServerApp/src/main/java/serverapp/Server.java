package serverapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.protobuf.Empty;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import services.ProtoUser;
import services.SessionId;
import services.UserServiceGrpc;
import userOperations.User;
import userOperations.UserOperations;


import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Server extends UserServiceGrpc.UserServiceImplBase {

    private static int svcPort = 8000;
    private static UserOperations userOps;
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
            GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
            FirestoreOptions options = FirestoreOptions.newBuilder().setCredentials(credentials).build();
            Firestore db = options.getService();
            userOps = new UserOperations(db);
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
            User user = new User(protoUser);
            user = userOps.login(user);
            SessionId sessionId;
            if (user != null && sessionQueue.contains(user.getUsername())) {
                responseObserver.onNext(SessionId.newBuilder().setAlreadyLoggedIn(true).build());
                responseObserver.onCompleted();
                return;
            }
            if (user == null) {
                sessionId = SessionId.newBuilder().setCredentials(false).setAlreadyLoggedIn(false).build();
            } else {
                sessionId = SessionId.newBuilder().setId(user.getUsername()).setCredentials(true).setAlreadyLoggedIn(false).build();
                sessionQueue.add(user.getUsername());
            }
            responseObserver.onNext(sessionId);
            responseObserver.onCompleted();
        }
    }

    public void close(SessionId request, StreamObserver<Empty> responseObserver) {
        synchronized (monitor) {
            sessionQueue.remove(request.getId());
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        }
    }


}
