import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.vision.v1.EntityAnnotation;
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


    static void sub(boolean isPremium){
        String topic = isPremium? PREMIUM_TOPIC : FREE_TOPIC;
        ProjectSubscriptionName projSubscriptionName =
                ProjectSubscriptionName.of(PROJECT_ID, topic);
        Subscriber subscriber =
                Subscriber.newBuilder(projSubscriptionName,
                        new MessageReceiveHandler(isPremium))
                        .build();
        subscriber.startAsync().awaitRunning();
        while (true);
    }


    private static class MessageReceiveHandler implements MessageReceiver {

        MessageReceiveHandler(boolean isPremium) {
            this.isPremium = isPremium;
        }

        boolean isPremium;

        public void receiveMessage(PubsubMessage msg, AckReplyConsumer ackReply) {
            try {
                String imageName = msg.getData().toStringUtf8();
                ByteString content = ImageRepository.downloadImage(imageName);
                if(content == null) throw new NullPointerException();
                EntityAnnotation text = Vision.detectText(content);
                ResultDB.putText(imageName,text);
                ImageRepository.deleteImage(imageName);
                TranslatePublisher.publishRequest(text,imageName,isPremium);
            } catch (IOException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            catch (NullPointerException e){
                System.out.println("Image not present");
            } finally {
                ackReply.ack();
            }

        }
    }
}
