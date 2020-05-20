package clientapp;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import services.ProtoUser;
import services.SessionId;
import services.UserServiceGrpc;

import java.util.*;


public class Client {

    private static String svcIP = "localhost";
    //private static String svcIP = "35.246.73.129";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static UserServiceGrpc.UserServiceBlockingStub blockingStub;
    private static UserServiceGrpc.UserServiceStub noBlockStub;
    private static SessionId sessionId;




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
            blockingStub = UserServiceGrpc.newBlockingStub(channel);
            noBlockStub = UserServiceGrpc.newStub(channel);
            do {
                try {
                    int option = Menu();
                    switch (option) {
                        case 0:
                            login();
                            break;
                        case 1:
                            logOut();
                            break;
                        case 2:
                            break;
                        case 3:
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

    static int Menu() {
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("######## MENU ##########");
            System.out.println("Options:");
            System.out.println(" 0: login");
            System.out.println(" 1: logout");
            System.out.println(" 2: Delete a field");
            System.out.println(" 3: Get Documents in parish");
            System.out.println(" 4: Get Documents with ID greater than a given one, and with a given parish and event");
            System.out.println("..........");
            System.out.println("99: Exit");
            System.out.print("Enter an Option:");
            option = scan.nextInt();
        } while (!((option >= 0 && option <= 8) || option == 99));
        return option;
    }

    public static void login(){
        if(sessionId != null){
            System.out.println("You are already logged in");
            return;
        }
        boolean terminated = false;
        do{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert username");
        String username = scanner.next();
        System.out.println("Insert your account type (Free/Premium)");
        String accountType = scanner.next();
        ProtoUser user = ProtoUser.newBuilder().setUsername(username).setAccountType(accountType).build();
        sessionId = blockingStub.login(user);
        if(sessionId.getAlreadyLoggedIn()){
            System.out.println("This user is already using the system, wait a minute and try again");
            continue;
        }
        if(!sessionId.getCredentials()){
            System.out.println("Check your input and try again");
            continue;
        }
        terminated = true;
        }while (!terminated);
        System.out.println("login successful");

    }

    public static void logOut(){
        if(sessionId == null){
            System.out.println("You are not logged in");
            return;
        }
        blockingStub.close(sessionId);
        sessionId = null;
        System.out.println("Logged out!");
    }
}
