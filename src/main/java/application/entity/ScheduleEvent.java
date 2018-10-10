package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ScheduleEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(columnDefinition = "text")
    String description;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Schedule.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_schedule")
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();

    public ScheduleEvent() {
    }
}
