import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Image;
import com.google.protobuf.ByteString;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Vision {


    public static String detectText(ByteString imgBytes)  {

        List<AnnotateImageRequest> requests = new ArrayList<>();
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    return String.format("Error: %s\n", res.getError().getMessage());
                }

                // For full list of available annotations, see http://g.co/cloud/vision/docs
                /*for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                    toRet.add(String.format("Text: %s\n", annotation.getDescription()));
                }*/
                return res.getTextAnnotationsList().get(0).getDescription();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
