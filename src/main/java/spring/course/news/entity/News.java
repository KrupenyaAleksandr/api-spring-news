package spring.course.news.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class News {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "head")
    private String head;

    @Column(name = "body")
    private String body;

    @Column(name = "date_create")
    private Date dateCreate;

    @JoinColumn(name = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserData idUser;

    @JoinColumn(name = "id_news")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentsList;

    public News(String head, String body, Date dateCreate, UserData idUser) {
        this.head = head;
        this.body = body;
        this.dateCreate = dateCreate;
        this.idUser = idUser;
    }
}
