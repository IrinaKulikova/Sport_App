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
    @JoinColumn(name = "training_type_id")
    TrainingType trainingType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filiation_id")
    @JsonIgnore
    Filiation filiation;

    public Training() {
    }
}