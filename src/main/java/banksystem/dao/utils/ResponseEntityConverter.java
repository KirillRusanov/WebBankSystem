package banksystem.dao.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class ResponseEntityConverter {

    @Value("${export.filename}")
    private String fileName;

    public ResponseEntity<InputStreamResource> convertToResponseEntity(File file) throws FileNotFoundException {
        HttpHeaders respHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType("text","json");
        respHeaders.setContentType(mediaType);
        respHeaders.setContentDispositionFormData("attachment", fileName);

        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    }
}
