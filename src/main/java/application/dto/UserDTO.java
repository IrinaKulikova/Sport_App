package application.dto;

import lombok.Data;

@Data
public class UserDTO {

    String firstName;
    String lastName;
    String email;
    String phone;
    String password;

    public UserDTO() {
    }
}
