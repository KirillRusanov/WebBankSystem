package banksystem.web.controller;

import banksystem.service.JsonImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api/json")
public class ImporterController {

    @Autowired
    private JsonImporter jsonImporter;

    @ResponseBody
    @GetMapping(value = "import")
    public List importFromJson() throws IOException {
        return jsonImporter.importFromJson();
    }

    @ResponseBody
    @PostMapping(value = "import-file", headers = "content-type=multipart/form-data")
    public List importFromJsonFile(@RequestParam("file") MultipartFile file) {
        return jsonImporter.importFromJson(file);
    }


}
