package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "time", targetEntity = Training.class, cascade = CascadeType.ALL)
    @JsonIgnore
    List<Training> trainings = new ArrayList<>();

    public Time() {
    }
}
