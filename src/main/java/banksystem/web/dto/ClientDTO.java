package banksystem.web.dto;

import banksystem.dao.model.Count;
import banksystem.dao.model.security.Role;
import banksystem.web.dto.validation.Mail;
import banksystem.web.dto.validation.Passport;
import banksystem.web.dto.validation.Phone;
import banksystem.web.dto.validation.Username;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
public class ClientDTO {

    private Long id;

    @Mail
    @Email(message = "! must be in the format of an email address")
    private String email;

    @Username
    @Size(max = 16, min = 4, message = "! username must be between 4 characters and 16 characters")
    private String username;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,20}",
            message = "! Password must: " +
            "\n* Be at least 8 characters and no more than 20" +
            "\n* Contain at least 1 uppercase letter" +
            "\n* Contain special characters or numbers")
    private String password;

    private Role role;

    @Size(max = 14, min = 2, message = "! name must be between 2 characters and 14 characters")
    private String name;

    @Size(max = 16, min = 2, message = "! surname must be between 2 characters and 16 characters")
    private String surname;

    @Size(max = 18, min = 2, message = "! patronymic must be between 2 characters and 18 characters")
    private String patronymic;

    @Size(max = 28, min = 4, message = "! address must be between 4 characters and 28 characters")
    private String address;

    @Passport
    @Size(max = 14, min = 14, message = "! passport number must be 14 characters")
    private String passNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "! incorrect date of birth")
    private Date birthday;

    @Phone
    @Size(max = 13, min = 12, message = "! phone number must be 13 characters")
    private String phoneNumber;

    private List<Count> counts;

    private boolean isVerified;

    private String profilePhoto;
}
