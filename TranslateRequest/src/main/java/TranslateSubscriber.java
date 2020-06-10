import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TranslateSubscriber {
    private static final String PROJECT_ID = "G13-LEIC61D-V1920";
    private final static String FREE_TOPIC = "free-translate", PREMIUM_TOPIC = "premium-translate";

    static void sub(boolean isPremium) {
        String topic = isPremium ? PREMIUM_TOPIC : FREE_TOPIC;
        ProjectSubscriptionName projSubscriptionName =
                ProjectSubscriptionName.of(PROJECT_ID, topic);
        Subscriber subscriber =
                Subscriber.newBuilder(projSubscriptionName,
                        new MessageReceiveHandler(isPremium))
                        .build();
        subscriber.startAsync().awaitRunning();
        while (true) ;
    }


    private static class MessageReceiveHandler implements MessageReceiver {

        public MessageReceiveHandler(boolean isPremium) {
            this.isPremium = isPremium;
        }

        boolean isPremium;

        public void receiveMessage(PubsubMessage msg, AckReplyConsumer ackReply) {
            String text = msg.getData().toStringUtf8();
            String currLang = msg.getAttributesOrDefault("lang", null);
            String imageName = msg.getAttributesOrDefault("imageName", null);
            String user = msg.getAttributesOrDefault("user",null);
            try {
                Translator.translate(user,imageName, text, currLang);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                ackReply.ack();
            }
        }
    }

}
