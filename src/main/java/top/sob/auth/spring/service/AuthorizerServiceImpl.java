package top.sob.auth.spring.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.sob.auth.spring.bean.User;
import top.sob.auth.spring.dao.jdbc.UserDao;
import top.sob.auth.spring.dao.redis.LoginCacheDao;

import java.util.List;

public class AuthorizerServiceImpl implements AuthorizerService {

    @Autowired
    UserDao user;

    @Autowired
    LoginCacheDao loginCache;

    @Autowired
    HttpServletRequest request;

    @Override
    public long register(String username, String password) {
        if (user.exists(username))
            return -1;

        var id = user.size();
        var u = new User(id, username, password);

        user.put(u);
        loginCache.setLogin(request.getRemoteAddr(), id);

        return id;
    }

    @Override
    public long login(String username, String password) {
        if (!user.login(username, password))
            return -1;

        var u = user.getByName(username);
        var id = u.getId();
        loginCache.setLogin(request.getRemoteAddr(), id);

        return id;
    }

    @Override
    public long currentUser() {
        return loginCache.getLogin(request.getRemoteAddr());
    }

    @Override
    public boolean logout() {
        return loginCache.removeLogin(request.getRemoteAddr());
    }

    @Override
    public User getUser(long id) {
        var u = user.getById(id);
        u.setPassword(null);
        return u;
    }

    @Override
    public List<User> searchUsers(String username) {
        var us = user.searchByName(username);
        us.forEach(u -> u.setPassword(null));
        return us;
    }
}
