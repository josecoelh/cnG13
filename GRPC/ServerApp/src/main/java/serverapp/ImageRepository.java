package serverapp;

import com.google.cloud.storage.*;
import services.Image;
import services.ImageId;

public class ImageRepository {
    private final String BUCKET = "bucket-cn";
    private Storage storage;
    private final Object mutex = new Object();

    ImageRepository() {
        StorageOptions storageOptions = StorageOptions.getDefaultInstance();
        storage = storageOptions.getService();
    }

    ImageId uploadImage(Image image) {
        synchronized (mutex) {
            BlobId blobId = BlobId.of(BUCKET, image.getImageName());
            if (storage.get(blobId) != null)
                return ImageId.newBuilder().setFailed(true).setErrorMsg("Name taken, choose a new name for your image").build();
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(image.getContentType()).build();
            storage.create(blobInfo, image.getImage().toByteArray());
            return ImageId.newBuilder().setImageId(image.getImageName()).setFailed(false).build();
        }
    }
}

