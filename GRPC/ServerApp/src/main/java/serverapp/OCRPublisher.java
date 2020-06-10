package serverapp;

import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import services.OCReply;
import services.OCRequest;

import java.io.IOException;

public class OCRPublisher {

    final static String FREE_TOPIC = "free-ocr", PREMIUM_TOPIC = "premium-ocr";
    private static final String PROJECT_ID = "G13-LEIC61D-V1920";


    void publishRequest(OCRequest req) throws IOException {
        String topic = req.getUser().getIsPremium()? PREMIUM_TOPIC : FREE_TOPIC;
        TopicName tName = TopicName.ofProjectTopicName(PROJECT_ID, topic);
        Publisher publisher = Publisher.newBuilder(tName).build();
        ByteString msgData = ByteString.copyFromUtf8(req.getImageId());
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                .setData(msgData)
                .putAttributes("user",req.getUser().getId())
                .build();
        publisher.publish(pubsubMessage);
        publisher.shutdown();
    }
}
