package banksystem.web.controller;

import banksystem.service.JsonExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private JsonExporter jsonExporter;
    @Value("${export.filename}")
    private String fileName;

    private ResponseEntity<InputStreamResource> convertToResponseEntity(File file) throws FileNotFoundException {
        HttpHeaders respHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType("text","json");
        respHeaders.setContentType(mediaType);
        respHeaders.setContentDispositionFormData("attachment", fileName);

        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "")
    public ResponseEntity<InputStreamResource> exportToJson() throws IOException {
        File file = jsonExporter.exportToJson();
        return convertToResponseEntity(file);
    }
}
