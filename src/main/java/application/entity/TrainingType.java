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

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Training.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
    @JsonIgnore
    List<Training> trainings = new ArrayList<>();

    public TrainingType(){ }
}
