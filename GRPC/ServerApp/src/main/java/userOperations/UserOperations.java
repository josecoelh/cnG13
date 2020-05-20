package userOperations;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

import java.util.concurrent.ExecutionException;


public class UserOperations {
    private final static String COLLECTION = "Users";
    private static Firestore db;
    private static CollectionReference cRef;

    public UserOperations(Firestore database) {
        db = database;
        cRef = db.collection(COLLECTION);
    }

    /**
     * Method that logs user into the Collection Users, the user needs to exist previously
     * returns object User to serve as Session identifier, if User is not found on the collection or the wrong account type was given returns null;
     **/
    public User login(User user) {
        DocumentReference docRef = cRef.document(user.username);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = null;
        try {
            document = future.get();
            if (document.exists()) {
                if(document.get("accountType").equals(user.getAccountType())){
                    return user;
                }
                return null;
            } else {
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


}
