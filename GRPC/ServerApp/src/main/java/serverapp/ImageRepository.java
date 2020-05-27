package serverapp;

import com.google.cloud.storage.*;
import services.Image;
import services.ImageId;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ImageRepository {
    private final String FREE_BUCKET = "free_cn";
    private final String PREMIUM_BUCKET = "premium_cn";
    private Storage storage;
    private final Object mutex = new Object();

    ImageRepository() {
        StorageOptions storageOptions = StorageOptions.getDefaultInstance();
        storage = storageOptions.getService();
    }

    ImageId uploadImage(Image image) {
        synchronized (mutex) {
            String bucketName = image.getUser().getIsPremium() ? PREMIUM_BUCKET : FREE_BUCKET;
            BlobId blobId = BlobId.of(bucketName, image.getImageName());
            if (storage.get(blobId) != null)
                return ImageId.newBuilder().setFailed(true).setErrorMsg("Name taken, choose a new name for your image").build();
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(image.getContentType()).build();
            storage.create(blobInfo, image.getImage().toByteArray());
            return ImageId.newBuilder().setImageId(image.getImageName()).setFailed(false).build();
        }
    }
}

