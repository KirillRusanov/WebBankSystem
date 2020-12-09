package banksystem.service;

import banksystem.web.mapper.ClientMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Component
public class JsonExporter {
    @Autowired
    private ClientService clientService;

    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
    }

    public InputStreamResource exportToJson(String filename) throws IOException {
        File file = new File(filename);
        List clients = clientService.getAll();
        List clientsDTO = ClientMapper.INSTANCE.convertToDTO(clients);
        String json = objectMapper.writeValueAsString(clientsDTO);
        objectMapper.writeValue(file, json);
        return new InputStreamResource(new FileInputStream(file));
    }
}
