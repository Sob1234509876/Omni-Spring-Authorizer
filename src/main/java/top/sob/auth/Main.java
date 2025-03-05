package top.sob.auth;

import org.springframework.boot.SpringApplication;
import top.sob.auth.spring.configuration.AuthorizerConfiguration;

public final class Main {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizerConfiguration.class, args);
    }
}
