package banksystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileManager {

    @Value("${storage.path}")
    String storagePath;

    void upload(byte[] resource, String keyName) throws IOException {
        Path path = Paths.get(storagePath, keyName);
        Path file = Files.createFile(path);
        try (FileOutputStream stream = new FileOutputStream(file.toString())) {
            stream.write(resource);
        }
    }

    void delete(String keyName) throws IOException {
        Path path = Paths.get(storagePath + keyName);
        Files.deleteIfExists(path);
    }
}
