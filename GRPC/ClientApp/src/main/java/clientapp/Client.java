package clientapp;


import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import services.*;

import java.io.File;
import java.io.IOException;
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
                System.out.println(" 4: Get Documents with ID greater than a given one, and with a given parish and event");
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
            String basePath = new File("").getAbsolutePath();
            System.out.println(basePath);
            System.out.println("Place your image on the folder (resources/Image) and insert it's name");
            String imgName = scanner.next();
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
}
