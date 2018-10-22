package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="training_type")
public class TrainingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @Column(columnDefinition = "text")
    String description;

    @OneToMany(targetEntity = Training.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_type_id")
    @JsonIgnore
    List<Training> trainings = new ArrayList<>();

    public TrainingType(){ }
}
