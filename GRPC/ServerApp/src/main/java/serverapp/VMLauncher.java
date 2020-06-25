package serverapp;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.compute.Compute;
import com.google.api.services.compute.ComputeScopes;
import com.google.api.services.compute.model.InstanceGroupManager;
import com.google.api.services.compute.model.InstanceGroupManagerList;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class VMLauncher {
    final static String MACHINE_TYPE = "f1-micro",
            PROJECT_ID = "g13-leic61d-v1920",
            ZONE_NAME = "europe-west1-c",
            INSTANCE_GROUP_OCR = "instance-group-ocr",
            INSTANCE_GROUP_TRANSLATE = "instance-group-translation";
    Compute compute;

    VMLauncher(){
        GoogleCredentials credential = null;
        try {
            credential = GoogleCredentials.getApplicationDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> scopes = new ArrayList<>();
        scopes.add(ComputeScopes.COMPUTE);
        credential = credential.createScoped(scopes);
        HttpTransport transport = null;
        try {
            transport = GoogleNetHttpTransport.newTrustedTransport();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        HttpRequestInitializer requestInit = new HttpCredentialsAdapter(credential);
        compute = new Compute
                .Builder(transport, jsonFactory, requestInit)
                .setApplicationName("bembig")
                .build();
    }


    private int getCurrentSize(){
        Compute.InstanceGroupManagers.List request = null;
        try {
            request = compute.instanceGroupManagers().list(PROJECT_ID, ZONE_NAME);
            InstanceGroupManagerList list = request.execute();
            for (InstanceGroupManager grp : list.getItems()) {
                return grp.getTargetSize();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    void incrementVM(){
        int currSize = getCurrentSize();
        try {
            resizeInstanceGroup(++currSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void decrementVM(){
        int currSize = getCurrentSize();
        if(currSize == 1) return;
        try {
            resizeInstanceGroup(--currSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resizeInstanceGroup(int newSize) throws IOException
    {
        Compute.InstanceGroupManagers.Resize requestT = compute.instanceGroupManagers()
                .resize(PROJECT_ID, ZONE_NAME, INSTANCE_GROUP_OCR, newSize);
        requestT.execute();
        Compute.InstanceGroupManagers.Resize requestO = compute.instanceGroupManagers()
                .resize(PROJECT_ID, ZONE_NAME, INSTANCE_GROUP_TRANSLATE, newSize);
        requestO.execute();
    }
}
