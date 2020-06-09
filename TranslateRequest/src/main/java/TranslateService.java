public class TranslateService {


    public static void main(String[] args) {
        boolean isPremium = Boolean.parseBoolean(args[0]);
        if (isPremium) {
            System.out.println("Listening for Premium messages");
        } else {
            System.out.println("Listening for Free messages");
        }
        TranslateSubscriber.sub(isPremium);
    }

}
