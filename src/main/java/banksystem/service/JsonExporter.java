package banksystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonExporter {
    @Autowired
    private ClientService clientService;
    @Value("${export.filename}")
    private String fileName;
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
    }

    public File exportToJson() throws IOException {
        File file = new File(fileName);
        List clients = clientService.getAll();
        String json = objectMapper.writeValueAsString(clients);
        objectMapper.writeValue(file, json);
        return file;
    }
}
