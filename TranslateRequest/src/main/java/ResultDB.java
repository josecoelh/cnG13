import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

class ResultDB {
    private final static String COLLECTION = "Users", SUB_COLLECTION = "OCR";;
    private static  GoogleCredentials credentials;
    private static CollectionReference ocrCollection;


    ResultDB(String user){
        try {
            credentials = GoogleCredentials.getApplicationDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FirestoreOptions options = FirestoreOptions.newBuilder().setCredentials(credentials).build();
        Firestore db = options.getService();
        CollectionReference uRef = db.collection(COLLECTION);
        DocumentReference uDoc = uRef.document(user);
        ocrCollection = uDoc.collection(SUB_COLLECTION);
    }


      void putText(String image,String language, String text){
        DocumentReference dRef = ocrCollection.document(image);
         HashMap<String, Object> map = new HashMap<String, Object>();
         map.put(language,text);
         dRef.update(map);
    }

}
