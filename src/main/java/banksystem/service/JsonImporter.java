package banksystem.service;

import banksystem.dao.model.Card;
import banksystem.dao.model.Client;
import banksystem.dao.model.Count;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@PropertySource("classpath:/application.properties")
@Component
public class JsonImporter {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CardService cardService;
    @Autowired
    private CountService countService;

    private ObjectMapper objectMapper;

    @Value("${fileJson}")
    private String path;

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
    }

    public void importFromJson() throws IOException {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Client[] clients = objectMapper.readValue(new File(path), Client[].class);
        saveData(clients);
    }

    public void importFromJson(MultipartFile file) {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Client[] clients = objectMapper.readValue(bytes, Client[].class);
                saveData(clients);
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    private void saveData(Client[] clients) {
        for (Client client : clients) {
            List<Count> counts = client.getCounts();
            client.setCounts(null);
            clientService.create(client);
            for (Count count : counts) {
                List<Card> cards = count.getCards();
                count.setCards(null);
                count.setClient_id(client);
                countService.create(count);
                for (Card card : cards) {
                    card.setCount(count);
                    cardService.create(card);
                }
            }
        }
    }
}
