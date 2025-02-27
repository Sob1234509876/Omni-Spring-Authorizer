package top.sob.auth.spring.dao;

import org.springframework.stereotype.Repository;
import top.sob.auth.spring.bean.User;

import java.util.List;

@Repository
public interface UserDao {
    User getById(long id);

    List<User> searchByName();
}
