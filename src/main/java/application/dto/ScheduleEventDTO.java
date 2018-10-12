package application.dto;

import lombok.Data;

@Data
public class ScheduleEventDTO {
    private int id;
    String name;
    String description;
    ScheduleEventDTO(){

    }
}
