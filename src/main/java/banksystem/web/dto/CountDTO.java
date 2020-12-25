package banksystem.web.dto;

import banksystem.dao.model.Card;
import lombok.Data;

import java.util.List;

@Data
public class CountDTO {

        private Long id;
        private String number;
        private Integer balance;
        private String currency;
        private List<Card> cards;
}
