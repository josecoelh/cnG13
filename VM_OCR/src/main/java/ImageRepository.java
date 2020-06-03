import com.google.cloud.ReadChannel;
import com.google.cloud.storage.*;
import com.google.common.io.ByteStreams;
import com.google.protobuf.ByteString;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ImageRepository {
    private static final String BUCKET = "bucket-cn";

    private static StorageOptions storageOptions = StorageOptions.getDefaultInstance();

    private static Storage storage =  storageOptions.getService();;



    static ByteString downloadImage(String image) throws IOException {
        Path downloadTo = Paths.get(image);
        BlobId blobId = BlobId.of(BUCKET, image);
        Blob blob = storage.get(blobId);
        if (blob == null) {
            System.out.println("No such Blob exists !");
            return null;
        }
        return ByteString.copyFrom(blob.getContent());
    }


    static void deleteImage(String image){
        Bucket bucket = storage.get(BUCKET);
        Blob blob = bucket.get(image);
        blob.delete();
    }


}