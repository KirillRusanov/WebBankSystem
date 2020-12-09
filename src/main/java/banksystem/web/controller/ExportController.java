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

import java.io.IOException;

@Controller
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private JsonExporter jsonExporter;

    @ResponseBody
    @GetMapping(value = "")
    public ResponseEntity<InputStreamResource> exportToJson() throws IOException {
        return jsonExporter.exportToJson();
    }
}
