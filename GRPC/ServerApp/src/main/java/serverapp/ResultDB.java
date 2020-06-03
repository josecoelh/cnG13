package serverapp;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ResultDB {
    private final static String COLLECTION = "OCR";
    private static GoogleCredentials credentials;
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


    static String getText(String image) {
        DocumentReference docRef = cRef.document(image);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = null;
        try {
            if (!document.exists()) return "Result not Ready try again later :p";
            document = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return (String) document.get("Text");
    }
}



