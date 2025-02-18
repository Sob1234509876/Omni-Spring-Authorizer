package top.sob.auth;

import org.springframework.boot.SpringApplication;
import top.sob.auth.spring.controller.AuthorizerController;

public final class Main {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizerController.class, args);
    }
}
