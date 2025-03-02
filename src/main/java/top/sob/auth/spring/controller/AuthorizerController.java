package top.sob.auth.spring.controller;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import top.sob.auth.spring.bean.User;
import top.sob.auth.spring.configuration.AuthorizerServiceConfiguration;
import top.sob.auth.spring.configuration.LoginCacheDaoConfiguration;
import top.sob.auth.spring.service.AuthorizerService;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/auth")
@Import({AuthorizerServiceConfiguration.class, LoginCacheDaoConfiguration.class})
@MapperScan("top.sob.auth.spring.dao.jdbc")
public class AuthorizerController {

    private static final Logger log = LogManager.getLogger(AuthorizerController.class);
    @Autowired
    AuthorizerService service;

    @PostConstruct
    public void init() {
        log.info("Loading authorizer...");
    }

    @PostMapping("/register")
    public long register(String username, String password) {
        return service.register(username, password);
    }

    @PostMapping("/login")
    public long login(String username, String password) {
        return service.login(username, password);
    }

    @GetMapping("/current-user")
    public long currentUser() {
        return service.currentUser();
    }

    @PostMapping("/logout")
    public boolean logout() {
        return service.logout();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return service.getUser(id);
    }

    @GetMapping("/search/user")
    public List<User> searchUsers(String username) {
        return service.searchUsers(username);
    }

}
