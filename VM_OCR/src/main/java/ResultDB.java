import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.vision.v1.EntityAnnotation;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ResultDB {
    private final static String COLLECTION = "OCR";
    private static  GoogleCredentials credentials;
    private static CollectionReference cRef;

    static {
        try {
            credentials = GoogleCredentials.getApplicationDefault();
            FirestoreOptions options = FirestoreOptions.newBuilder().setCredentials(credentials).build();
            Firestore db = options.getService();
            cRef = db.collection(COLLECTION);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


     static void putText(String image, EntityAnnotation text) throws ExecutionException, InterruptedException {
        DocumentReference dRef = cRef.document(image);
         HashMap<String, Object> map = new HashMap<String, Object>();
         map.put(text.getLocale(),text.getDescription());
         dRef.set(map);
    }

}
