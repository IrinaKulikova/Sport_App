package application.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    //день недели
    int dayofweek;
    //время начала занятия
    @Column(columnDefinition ="time")
    Date starttime;
    //вторичный ключ schedule_event
    @ManyToOne(targetEntity = ScheduleEvent.class)
    @JoinColumn(name="fk_schedule_event_schedule")
    int idSeduleEvent;
}
