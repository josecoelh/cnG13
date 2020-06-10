import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

import java.io.IOException;

public class TranslatePublisher {

    final static String FREE_TOPIC = "free-translate", PREMIUM_TOPIC = "premium-translate";
    private static final String PROJECT_ID = "G13-LEIC61D-V1920";


    static void publishRequest(EntityAnnotation text,String imageName, String user, boolean isPremium) throws IOException {
        String topic = isPremium? PREMIUM_TOPIC : FREE_TOPIC;
        TopicName tName = TopicName.ofProjectTopicName(PROJECT_ID, topic);
        Publisher publisher = Publisher.newBuilder(tName).build();
        ByteString msgData = ByteString.copyFromUtf8(text.getDescription());
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                .setData(msgData)
                .putAttributes("lang",text.getLocale())
                .putAttributes("imageName",imageName)
                .putAttributes("user",user)
                .build();
        publisher.publish(pubsubMessage);
        publisher.shutdown();
    }
}
