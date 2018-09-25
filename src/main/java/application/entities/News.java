package application.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String date;
    String description;
    String imageURL;

    public News() {
    }

    public News(String title, String description, String date, String imageURL) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.imageURL = imageURL;
    }
}
