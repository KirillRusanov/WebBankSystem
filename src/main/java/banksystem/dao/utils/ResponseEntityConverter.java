package banksystem.dao.utils;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public class ResponseEntityConverter {

    public static ResponseEntity<InputStreamResource> convertToResponseEntity(File file) throws IOException {
        HttpHeaders respHeaders = new HttpHeaders();

        respHeaders.setContentType(defineMediaType(file));
        respHeaders.setContentDispositionFormData("attachment", file.getName());

        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    }

    private static MediaType defineMediaType(File file) throws IOException {
        String[] mimeType = Files.probeContentType(file.toPath()).split("/");
        // Constructor parameters for MediaType. type - mimeType[0], subtype - mimeType[1]
        return new MediaType(mimeType[0], mimeType[1]);
    }
}
