import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import java.io.IOException;
import java.util.HashMap;

public class Database {

    private final static String COLLECTION = "CN-Text";
    private static CollectionReference cRef;

    public Database() {
        GoogleCredentials credentials = null;
        try {
            credentials = GoogleCredentials.getApplicationDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FirestoreOptions options = FirestoreOptions.newBuilder().setCredentials(credentials).build();
        Firestore db = options.getService();
        cRef = db.collection(COLLECTION);
    }

    void uploadResults(final String image, final String result){
        DocumentReference dRef = cRef.document(image);
        HashMap<String, Object> map = new HashMap<String, Object>() {
            {
                put("name", image);
                put("text", result);
            }
        };
        dRef.create(map);
    }
}
