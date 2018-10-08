package application.dto;

import lombok.Data;

@Data
public class AdministratorDTO {
    private String password;
    private String email;
    private String login;

    public AdministratorDTO() {
    }
}
