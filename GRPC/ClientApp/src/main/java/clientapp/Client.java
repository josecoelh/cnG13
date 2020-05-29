package clientapp;


import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import services.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.*;


public class Client {

    private static String svcIP = "localhost";
    //private static String svcIP = "35.246.73.129";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static ServiceGrpc.ServiceBlockingStub blockingStub;
    private static ServiceGrpc.ServiceStub noBlockStub;
    private static int INVALID = 100;

    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                svcIP = args[0];
                svcPort = Integer.parseInt(args[1]);
            }
            channel = ManagedChannelBuilder.forAddress(svcIP, svcPort)
                    // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                    // needing certificates.
                    .usePlaintext()
                    .build();
            blockingStub = ServiceGrpc.newBlockingStub(channel);
            noBlockStub = ServiceGrpc.newStub(channel);
            Session session = new Session(blockingStub);
            do {
                try {
                    int option = Menu(session);
                    switch (option) {
                        case 0:
                            session.login();
                            break;
                        case 1:
                            session.logOut();
                            break;
                        case 2:
                            imageUpload(session.getSession());
                            break;
                        case 3:
                            listImages(session.getSession());
                            break;
                        case 4:
                            requestOCR(session.getSession());
                            break;
                        case 99:
                            System.exit(0);
                    }
                } catch (Exception ex) {
                    System.out.println("Erro executing operations!");
                    ex.printStackTrace();
                }
            } while (true);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static int Menu(Session session) {
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("######## MENU ##########");
            System.out.println("Options:");
            if (!session.hasSession())
                System.out.println(" 0: login");
            if (session.hasSession()) {
                System.out.println(" 1: logout");
                System.out.println(" 2: Upload an image");
                System.out.println(" 3: List your images");
                System.out.println(" 4: Request an OCR");
                System.out.println("..........");
                System.out.println("99: Exit");
                System.out.print("Enter an Option:");
            }
            option = scan.nextInt();
            if (option == 0 && session.hasSession()) option = INVALID;
            if (option != 0 && option <= 8 && !session.hasSession()) option = INVALID;
        } while (!((option >= 0 && option <= 8) || option == 99));
        return option;
    }

    private static void imageUpload(SessionId sessionId) throws IOException {
        ImageId res;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Place your image on the folder (resources/Image) and insert it's name");
            String imgName = scanner.nextLine();
            String path = new File("src/main/resources/Image/" + imgName)
                    .getAbsolutePath();
            File image = new File(path);
            ByteString imageContent = null;
            try {
                imageContent = ByteString.copyFrom(Files.readAllBytes(image.toPath()));
            } catch (NoSuchFileException e) {
                System.out.println("There is no image with that name on the folder");
                res = ImageId.newBuilder().setFailed(true).build();
                continue;
            }
            String contentType = Files.probeContentType(image.toPath());
            Image msg = Image.newBuilder()
                    .setImage(imageContent)
                    .setImageName(imgName)
                    .setContentType(contentType)
                    .setUser(sessionId)
                    .build();
            res = blockingStub.sendImage(msg);
            if (res.getFailed()) System.out.println(res.getErrorMsg());
        } while (res.getFailed());
        System.out.printf("Done! %s uploaded\n",res.getImageId());
    }

    private static void listImages(SessionId sessionId){
        System.out.println("If you just uploaded your image it might take while for it to appear in here");
        UserImages images = blockingStub.listUserImages(sessionId);
        for (String imageId:images.getImageIdList()) {
            System.out.println(imageId);
        }
    }


    private static void requestOCR(SessionId sessionId){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the image name for the OCR");
        String name = scanner.nextLine();
        OCRequest req = OCRequest.newBuilder().setImageId(name).setUser(sessionId).build();
        noBlockStub.requestOCR(req, new StreamObserver<OCReply>() {
            boolean isCompleted= false;
            @Override
            public void onNext(OCReply value) {
                String path = new File("src/main/resources/OCRResults/" + name+".txt")
                        .getAbsolutePath();
                File log = new File(path);

                try {
                    FileWriter fw = new FileWriter(path);
                    fw.write(String.format("Result : %s",value.getResult()));
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Check resources/OCRResults for your result");
                isCompleted = true;
            }
        });
    }
}
