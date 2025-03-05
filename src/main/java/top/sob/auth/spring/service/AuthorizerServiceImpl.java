package top.sob.auth.spring.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import top.sob.auth.spring.bean.User;
import top.sob.auth.spring.dao.jdbc.UserDao;
import top.sob.auth.spring.dao.redis.LoginCacheDao;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AuthorizerServiceImpl implements AuthorizerService {

    @NonNull
    UserDao user;

    @NonNull
    LoginCacheDao loginCache;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Override
    public long register(String username, String password) {
        if (user.exists(username))
            return -1;

        var id = user.getNextId();
        var u = new User(id, username, password, System.currentTimeMillis());

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
        if (u == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        else
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
