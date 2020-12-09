package banksystem.service;

import banksystem.web.mapper.ClientMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    @Value("${ExportFileName}")
    private String fileName;
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
    }

    public ResponseEntity<InputStreamResource> exportToJson() throws IOException {
        File file = new File(fileName);
        List clients = clientService.getAll();
        List clientsDTO = clientMapper.INSTANCE.convertToDTO(clients);
        String json = objectMapper.writeValueAsString(clientsDTO);
        objectMapper.writeValue(file, json);
        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));

        HttpHeaders respHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType("text","json");
        respHeaders.setContentType(mediaType);
        respHeaders.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
    }
}
