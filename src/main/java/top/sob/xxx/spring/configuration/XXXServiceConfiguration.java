package top.sob.xxx.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sob.xxx.spring.service.XXXService;
import top.sob.xxx.spring.service.XXXServiceImpl;

@Configuration
public class XXXServiceConfiguration {
    @Bean("service")
    public XXXService getService() {
        return new XXXServiceImpl();
    }
}
