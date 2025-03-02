package top.sob.auth.test.spring.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sob.auth.spring.EnableAuthorizerServer;

@SpringBootApplication
@RestController
@EnableAuthorizerServer
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/greet")
    public String getGreeting() {
        return "Hello world!";
    }
}
