package banksystem.web.controller;

import banksystem.service.JsonExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private JsonExporter jsonExporter;

    @ResponseBody
    @GetMapping(value = "")
    public ResponseEntity<InputStreamResource> exportToJson() throws IOException {
        String fileName = "export.json";
        HttpHeaders respHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType("text","json");
        respHeaders.setContentType(mediaType);
        respHeaders.setContentDispositionFormData("attachment", fileName);
        InputStreamResource isr = jsonExporter.exportToJson(fileName);
        return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
    }
}
