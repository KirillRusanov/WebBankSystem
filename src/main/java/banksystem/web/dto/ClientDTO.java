package banksystem.web.dto;

import lombok.Data;
import java.sql.Date;


@Data
public class ClientDTO {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String passNumber;
    private Date birthday;
    private String phoneNumber;

}
