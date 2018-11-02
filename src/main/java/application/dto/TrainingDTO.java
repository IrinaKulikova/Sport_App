package application.dto;

import lombok.Data;

@Data
public class TrainingDTO {
    int dayid;
    int timeid;
    int trainingtypeid;
    int filiationid;

    public TrainingDTO() {
    }
}
