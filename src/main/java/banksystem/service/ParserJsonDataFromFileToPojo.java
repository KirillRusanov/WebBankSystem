package banksystem.service;

import banksystem.dao.model.Card;
import banksystem.dao.model.Client;
import banksystem.dao.model.Count;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ParserJsonDataFromFileToPojo {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CardService cardService;
    @Autowired
    private CountService countService;

    ObjectMapper objectMapper = new ObjectMapper();

    public void parse() throws IOException {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        Client[] clients = objectMapper.readValue(new File(
                "D:\\GitHUB\\WebBankSystem\\src\\main\\resources\\data\\user.json"), Client[].class);
        recordingToDatabase(clients);

    }
    public String parse(MultipartFile file) {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Client[] clients = objectMapper.readValue(bytes, Client[].class);
                recordingToDatabase(clients);
                return "You have successfully downloaded";
            } catch (Exception e) {
                return "You were unable to download";
            }
        } else {
            return "Unsuccessful upload";
        }
    }

    private void recordingToDatabase(Client[] clients) {
        for(Client client : clients) {
            List<Count> counts = client.getCounts();
            client.setCounts(null);
            clientService.create(client);
            for (Count count : counts) {
                List<Card> cards = count.getCards();
                count.setCards(null);
                count.setClient_id(client);
                countService.create(count);
                for(Card card : cards) {
                    card.setCount(count);
                    cardService.create(card);
                }
            }
        }
    }
}
