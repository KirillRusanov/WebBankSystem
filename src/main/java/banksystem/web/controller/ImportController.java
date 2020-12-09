package banksystem.web.controller;

import banksystem.service.JsonImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api/import")
public class ImportController {

    @Autowired
    private JsonImporter jsonImporter;

    @ResponseBody
    @PostMapping(value = "", headers = "content-type=multipart/form-data")
    public void importFromJsonFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            jsonImporter.importFromJson();
        } else {
            jsonImporter.importFromJson(file);
        }
    }
}
