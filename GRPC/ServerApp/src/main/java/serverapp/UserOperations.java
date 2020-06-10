package serverapp;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import services.ProtoUser;
import services.UserImages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class UserOperations {
    private final static String COLLECTION = "Users";
    private static CollectionReference cRef;

    public UserOperations() {
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

    /**
     * Method that logs user into the Collection Users, the user needs to exist previously
     * returns object User to serve as Session identifier, if User is not found on the collection or the wrong account type was given returns null;
     **/
    public ProtoUser login(ProtoUser user) {
        DocumentReference docRef = cRef.document(user.getUsername());
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

    public void addUserImg(String username, String imageId)  {
        List<String> images = getUserImg(username);
        images.add(imageId);
        DocumentReference docRef = cRef.document(username);
        docRef.update("images", images);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeUserImg(String username, String imageId)  {
        List<String> images = getUserImg(username);
        images.remove(imageId);
        DocumentReference docRef = cRef.document(username);
        docRef.update("images", images);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<String> getUserImg(String username){
        DocumentReference docRef = cRef.document(username);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document  = null;
        try {
            document = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return  (List<String>) document.get("images");
    }

    public UserImages listUserImages(String username){
        List<String> images = getUserImg(username);
        return UserImages.newBuilder().addAllImageId(images).build();
    }


}
