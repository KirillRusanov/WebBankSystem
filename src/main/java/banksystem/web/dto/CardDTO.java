package banksystem.web.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CardDTO {

    private Long id;
    private String number;
    private String pin;
    private Date birthday;
}
