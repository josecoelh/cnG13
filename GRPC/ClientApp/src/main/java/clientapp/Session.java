package clientapp;

import services.ProtoUser;
import services.ServiceGrpc;
import services.SessionId;

import java.util.Scanner;

class Session {

    Session(ServiceGrpc.ServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
        sessionId = null;
    }

    private  SessionId sessionId;
    private ServiceGrpc.ServiceBlockingStub blockingStub;

    boolean hasSession(){ return sessionId!=null;}
    public SessionId getSession(){ return sessionId;}

    void login() {
        if (sessionId != null) {
            System.out.println("You are already logged in");
            return;
        }
        boolean terminated = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert username");
            String username = scanner.next();
            System.out.println("Insert your account type (Free/Premium)");
            String accountType = scanner.next();
            ProtoUser user = ProtoUser.newBuilder().setUsername(username).setAccountType(accountType).build();
            sessionId = blockingStub.login(user);
            if (sessionId.getAlreadyLoggedIn()) {
                System.out.println("This user is already using the system, wait a minute and try again");
                continue;
            }
            if (!sessionId.getCredentials()) {
                System.out.println("Check your input and try again");
                continue;
            }
            terminated = true;
        } while (!terminated);
        System.out.println("login successful");

    }

    void logOut() {
        if (sessionId == null) {
            System.out.println("You are not logged in");
            return;
        }
        blockingStub.close(sessionId);
        sessionId = null;
        System.out.println("Logged out!");
    }
}
