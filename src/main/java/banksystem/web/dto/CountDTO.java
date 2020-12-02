package banksystem.web.dto;

import lombok.Data;

@Data
public class CountDTO {

        private Long id;
        private String number;
        private Integer balance;
        private String currency;
}
