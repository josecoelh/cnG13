package serverapp;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ResultDB {
    private final static String COLLECTION = "Users", SUB_COLLECTION = "OCR";
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

    static String getText(String image, String user, String desiredLang) {
        DocumentReference uRef = cRef.document(user);
        CollectionReference ocrCollection = uRef.collection(SUB_COLLECTION);
        DocumentReference dRef = ocrCollection.document(image);
        ApiFuture<DocumentSnapshot> future = dRef.get();
        DocumentSnapshot document = null;
        try {
            document = future.get();
            if (!document.exists()) return null;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return (String) document.get(desiredLang == null ? "Original" : desiredLang);
    }



}



