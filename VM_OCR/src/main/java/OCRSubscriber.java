import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class OCRSubscriber {
    private static final String PROJECT_ID = "G13-LEIC61D-V1920";
    final static String FREE_TOPIC = "free-ocr", PREMIUM_TOPIC = "premium-ocr";


    static void freeSub(){
        ProjectSubscriptionName projsubscriptionName =
                ProjectSubscriptionName.of(PROJECT_ID, FREE_TOPIC);
        Subscriber subscriber =
                Subscriber.newBuilder(projsubscriptionName,
                        new MessageReceiveHandler(false))
                        .build();
        subscriber.startAsync().awaitRunning();
        while (true);
    }

    static void premiumSub(){
        ProjectSubscriptionName projsubscriptionName =
                ProjectSubscriptionName.of(PROJECT_ID, PREMIUM_TOPIC);
        Subscriber subscriber =
                Subscriber.newBuilder(projsubscriptionName,
                        new MessageReceiveHandler(true))
                        .build();
        subscriber.startAsync().awaitRunning();
    }

    private static class MessageReceiveHandler implements MessageReceiver {

        public MessageReceiveHandler(boolean isPremium) {
            this.isPremium = isPremium;
        }

        boolean isPremium;

        public void receiveMessage(PubsubMessage msg, AckReplyConsumer ackReply) {
            try {
                String imageName = msg.getData().toStringUtf8();
                ByteString content = ImageRepository.downloadImage(imageName);
                if(content == null) throw new NullPointerException();
                String text = Vision.detectText(content);
                ResultDB.putText(imageName,text);
                ImageRepository.deleteImage(imageName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (NullPointerException e){
                System.out.println("Image not present");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                ackReply.ack();
            }

        }
    }
}
