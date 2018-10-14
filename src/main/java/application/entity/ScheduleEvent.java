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
    //название занятия
    String name;
    //описание тренировки
    @Column(columnDefinition = "text")
    String description;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Schedule.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_schedule")
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();

    public ScheduleEvent(){

    }
    public ScheduleEvent(int id){
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
