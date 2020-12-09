package banksystem.web.dto;

import banksystem.dao.model.Count;
import lombok.Data;

import java.sql.Date;
import java.util.List;

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
    private List<Count> counts;
}
