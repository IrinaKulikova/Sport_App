package application.dto;

import lombok.Data;

@Data
public class ScheduleDTO {
    private int id;
    int dayid;
    String starttime;
    int eventschedule;

    public ScheduleDTO() {
    }
}
