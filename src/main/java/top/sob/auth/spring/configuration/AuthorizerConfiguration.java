package top.sob.auth.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.sob.auth.spring.controller.AuthorizerController;
import top.sob.auth.spring.service.AuthorizerService;

@SpringBootApplication
@Configuration
@Import(AuthorizerServiceConfiguration.class)
public class AuthorizerConfiguration implements WebMvcConfigurer {

    @Autowired
    AuthorizerService authService;

    @Bean("authController")
    public AuthorizerController getAuthorizerController() {
        return new AuthorizerController(authService);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*");
    }
}
