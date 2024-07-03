package spring.course.news.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "comment")
@Entity
@Data
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "body")
    private String body;

    @JoinColumn(name = "id_news")
    @ManyToOne(fetch = FetchType.LAZY)
    private News idNews;

    @JoinColumn(name = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserData idUser;
}
