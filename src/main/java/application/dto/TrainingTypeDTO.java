package application.dto;

import lombok.Data;

@Data
public class TrainingTypeDTO {
    int id;
    String name;
    String description;

    TrainingTypeDTO() {
    }
}
