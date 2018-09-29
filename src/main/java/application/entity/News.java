package application.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String date;
    String description;

    @Column(name = "image_url")
    String imageURL;

    public News(String title, String description, String date, String imageURL) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.imageURL = imageURL;
    }

    public News() {
    }
}
