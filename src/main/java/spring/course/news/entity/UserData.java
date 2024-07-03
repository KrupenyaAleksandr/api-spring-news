package spring.course.news.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "user_data")
@Entity
@Data
public class UserData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @JoinColumn(name = "id_user")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<News> newsList;
}
