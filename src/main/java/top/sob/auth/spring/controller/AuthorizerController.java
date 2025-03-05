package top.sob.auth.spring.controller;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import top.sob.auth.spring.bean.User;
import top.sob.auth.spring.service.AuthorizerService;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthorizerController {

    static final Logger log = LogManager.getLogger(AuthorizerController.class);

    AuthorizerService authService;

    @PostConstruct
    public void init() {
        log.info("Loading authorizer...");
    }

    @PostMapping("/register")
    public long register(String username, String password) {
        return authService.register(username, password);
    }

    @PostMapping("/login")
    public long login(String username, String password) {
        return authService.login(username, password);
    }

    @GetMapping("/current-user")
    public long currentUser() {
        return authService.currentUser();
    }

    @PostMapping("/logout")
    public boolean logout() {
        return authService.logout();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return authService.getUser(id);
    }

    @GetMapping("/search/user")
    public List<User> searchUsers(String username) {
        return authService.searchUsers(username);
    }

}
