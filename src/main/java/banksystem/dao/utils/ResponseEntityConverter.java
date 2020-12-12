package banksystem.dao.utils;

import liquibase.util.file.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResponseEntityConverter {

    public static ResponseEntity<InputStreamResource> convertToResponseEntity(File file) throws FileNotFoundException {
        HttpHeaders respHeaders = new HttpHeaders();

        respHeaders.setContentType(defineMediaType(file));
        respHeaders.setContentDispositionFormData("attachment", file.getName());

        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    }

    private static MediaType defineMediaType(File file) {
        String format = FilenameUtils.getExtension(file.getName());
        return new MediaType("text", format);
    }
}
