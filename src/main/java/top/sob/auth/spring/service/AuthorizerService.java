package top.sob.auth.spring.service;

import org.springframework.stereotype.Service;
import top.sob.auth.spring.bean.User;

import java.util.List;

@Service
public interface AuthorizerService {

    long register(String username, String password);

    long login(String username, String password);

    long currentUser();

    boolean logout();

    User getUser(long id);

    List<User> searchUsers(String username);

}
