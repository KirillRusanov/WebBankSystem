package banksystem.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;

@Data
public class TransferDTO {

    private Long id;

    private String fromCard;

    @CreditCardNumber(message = "*Incorrect card number")
    private String toCard;

    @Digits(integer = 10, fraction = 10, message = "*Amount must be digit")
    private Integer amount;
}
