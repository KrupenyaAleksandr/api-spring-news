package spring.course.news.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.course.news.entity.UserData;

import java.util.List;

public interface UserDataRepository extends CrudRepository<UserData, Integer> {

    @Query("SELECT u FROM UserData u WHERE u.id = :idUser")
    public UserData findUserDataById(Integer idUser);

    @Query("SELECT u FROM UserData u WHERE u.login = :login AND u.password = :password")
    UserData getUserDataByLoginAndPassword(String login, String password);
}
