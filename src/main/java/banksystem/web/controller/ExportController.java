package banksystem.web.controller;

import banksystem.dao.utils.ResponseEntityConverter;
import banksystem.service.JsonExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private JsonExporter jsonExporter;
    @Autowired
    private ResponseEntityConverter responseEntityConverter;

    @ResponseBody
    @GetMapping(value = "")
    public ResponseEntity<InputStreamResource> exportToJson() throws IOException {
        File file = jsonExporter.exportToJson();
        return responseEntityConverter.convertToResponseEntity(file);
    }
}
