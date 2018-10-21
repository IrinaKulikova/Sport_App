package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Time time;

    @ManyToOne(targetEntity = Day.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "day")
    @JsonIgnore
    Day day;

    @ManyToOne(targetEntity = TrainingType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "type")
    TrainingType trainingType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filiation")
    @JsonIgnore
    Filiation filiation;

    public Training() {
    }
}