package banksystem.web.dto.security;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthenticationClientDTO {

    @NotEmpty(message = "! username must not be empty")
    private String username;

    @NotEmpty(message = "! password must not be empty")
    private String password;
}
