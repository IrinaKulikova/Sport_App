package application.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @ManyToOne(targetEntity = Day.class,fetch = FetchType.EAGER)
    @JoinColumn(name="dayid")
    Day day;

    @Column(columnDefinition ="time")
    private Date starttime;

    //вторичный ключ schedule_event
    @ManyToOne(targetEntity = ScheduleEvent.class,fetch = FetchType.EAGER)
    @JoinColumn(name="event_schedule")
    ScheduleEvent scheduleEvent;
}
