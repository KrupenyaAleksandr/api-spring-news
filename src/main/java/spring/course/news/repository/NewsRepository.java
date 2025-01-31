package spring.course.news.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.course.news.entity.News;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

    @Query("SELECT n FROM News n")
    List<News> getAll();

    @Query("SELECT n FROM News n WHERE n.idUser.id = :userId")
    List<News> getNewsByUserId(Integer userId);

    News findNewsByHead(String head);
}