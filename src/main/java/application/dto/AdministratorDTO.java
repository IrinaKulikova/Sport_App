package application.dto;

import lombok.Data;

@Data
public class AdministratorDTO {
    private String login;
    private String password;

    public AdministratorDTO() {
    }
}
