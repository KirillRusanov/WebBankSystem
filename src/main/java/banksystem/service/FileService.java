package banksystem.service;

import banksystem.dao.model.Client;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class FileService {
    @Autowired
    private FileManager fileManager;
    @Autowired
    private ClientService clientService;

    public void upload(MultipartFile resource, Client client) throws IOException {
        String key = generateKey(resource.getName());
        String[] mimeType = Objects.requireNonNull(resource.getContentType()).split("/");
        // Constructor parameters for MediaType. type - mimeType[0], subtype - mimeType[1]
        key = key + "." + (mimeType[1]);

        if (!client.getProfilePhoto().equals("unknown.jpeg")) {
            fileManager.delete(client.getProfilePhoto());
        }

        client.setProfilePhoto(key);
        clientService.saveOrUpdate(client);
        fileManager.upload(resource.getBytes(), key);
    }

    private String generateKey(String name) {
        return DigestUtils.md5Hex(name + LocalDateTime.now().toString());
    }
}
