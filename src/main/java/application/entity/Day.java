package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "day" ,targetEntity = Training.class, cascade = CascadeType.ALL)
    @JsonIgnore
    List<Training> trainings = new ArrayList<>();

    public Day() {
    }
}
