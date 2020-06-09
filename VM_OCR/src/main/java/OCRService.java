import com.google.protobuf.ByteString;

import java.io.IOException;

public class OCRService {


    public static void main(String[] args) {
        boolean isPremium = Boolean.parseBoolean(args[0]);
        if (isPremium) {
            System.out.println("Listening for Premium messages");
        } else {
            System.out.println("Listening for Free messages");
        }
        OCRSubscriber.sub(isPremium);
    }



}


