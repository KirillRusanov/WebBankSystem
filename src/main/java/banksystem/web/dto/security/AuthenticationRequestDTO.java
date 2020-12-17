package banksystem.web.dto.security;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String email;
    private String password;

}
