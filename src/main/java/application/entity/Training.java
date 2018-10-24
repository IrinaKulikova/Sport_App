package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = application.entity.Time.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "time_fk")
    private application.entity.Time time;

    @ManyToOne(targetEntity = Day.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "day_fk")
    Day day;

    @ManyToOne(targetEntity = TrainingType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "training_type_fk")
    TrainingType trainingType;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Filiation.class)
    @JoinColumn(name = "filiation_fk")
    @JsonIgnore
    Filiation filiation;

    public Training() {
    }
}