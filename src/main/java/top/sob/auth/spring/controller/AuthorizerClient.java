package top.sob.auth.spring.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.sob.auth.spring.bean.User;

import java.util.List;

@FeignClient("auth-service")
@RequestMapping("/api/auth")
public interface AuthorizerClient {

    @PostMapping("/register")
    long register(String username, String password);

    @PostMapping("/login")
    long login(String username, String password);

    @GetMapping("/current-user")
    long currentUser();

    @PostMapping("/logout")
    long logout();

    @GetMapping("/user/{id}")
    User getUser(@PathVariable long id);

    @GetMapping("/search/user")
    List<User> searchUsers(String username);

}
