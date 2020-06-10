import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.vision.v1.EntityAnnotation;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ResultDB {
    private final static String COLLECTION = "Users", SUB_COLLECTION = "OCR";
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


     static void putText(String image, EntityAnnotation text, String user) throws ExecutionException, InterruptedException {
         DocumentReference uRef = cRef.document(user);
         CollectionReference ocrCollection = uRef.collection(SUB_COLLECTION);
         DocumentReference dRef = ocrCollection.document(image);
         HashMap<String, Object> map = new HashMap<String, Object>();
         map.put("Original",text.getDescription());
         dRef.set(map);
    }

}
