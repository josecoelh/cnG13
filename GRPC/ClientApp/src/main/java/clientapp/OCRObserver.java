package clientapp;


import io.grpc.stub.StreamObserver;
import services.ImageId;
import services.OCReply;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OCRObserver implements StreamObserver<OCReply> {
    boolean isCompleted = false;
    String name;

    public OCRObserver(String name) {
        this.name = name;
    }


    @Override
    public void onNext(OCReply value) {
        String path = new File("src/main/resources/OCRResults/" + name)
                .getAbsolutePath();
        File log = new File(path);

        try {
            FileWriter fw = new FileWriter(path);
            fw.write(String.format("Result : %s", value.getResult()));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onCompleted() {
        System.out.println("Check resources/OCRResults for your result");
    }
}