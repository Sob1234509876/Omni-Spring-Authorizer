package top.sob.auth.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sob.auth.spring.configuration.AuthorizerServiceConfiguration;
import top.sob.auth.spring.service.AuthorizerService;

@SpringBootApplication
@EnableFeignClients
@RestController
@Import(AuthorizerServiceConfiguration.class)
@RequestMapping("/api/auth")
public class AuthorizerController {
    @Autowired
    AuthorizerService service;

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    StringRedisTemplate redis;
}
