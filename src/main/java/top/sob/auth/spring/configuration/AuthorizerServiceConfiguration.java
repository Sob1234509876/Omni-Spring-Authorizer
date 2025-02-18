package top.sob.auth.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sob.auth.spring.service.AuthorizerService;
import top.sob.auth.spring.service.AuthorizerServiceImpl;

@Configuration
public class AuthorizerServiceConfiguration {
    @Bean("service")
    public AuthorizerService getService() {
        return new AuthorizerServiceImpl();
    }
}
