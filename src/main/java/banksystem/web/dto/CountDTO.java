package banksystem.web.dto;

import banksystem.dao.model.Card;
import banksystem.dao.model.Client;
import banksystem.web.dto.validation.CountNumber;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CountDTO {

        private Long id;

        @CountNumber
        @Size(max = 16, min = 4, message = "! number must be between 4 characters and 16 characters")
        private String number;
        private Integer balance;
        private String currency;
        private List<Card> cards;
        private Client client_id;
}
