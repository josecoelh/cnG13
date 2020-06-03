public class OCRService {


    public static void main(String[] args) {

            if (Boolean.getBoolean(args[0])){
                System.out.println("Listening for Premium messages");
                OCRSubscriber.premiumSub();}
            else {
                System.out.println("Listening for Free messages");
                OCRSubscriber.freeSub();
            }

    }

}
