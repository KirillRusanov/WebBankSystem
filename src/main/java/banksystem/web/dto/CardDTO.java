package banksystem.web.dto;

import banksystem.dao.model.Count;
import lombok.Data;

import java.util.Date;

@Data
public class CardDTO {

    private Long id;
    private String number;
    private String pin;
    private Date term;
    private Count count;
}
