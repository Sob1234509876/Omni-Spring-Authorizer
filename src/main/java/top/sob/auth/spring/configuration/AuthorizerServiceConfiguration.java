package top.sob.auth.spring.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.sob.auth.spring.dao.jdbc.UserDao;
import top.sob.auth.spring.dao.redis.LoginCacheDao;
import top.sob.auth.spring.service.AuthorizerService;
import top.sob.auth.spring.service.AuthorizerServiceImpl;

@Configuration
@MapperScan("top.sob.auth.spring.dao.jdbc")
@Import(LoginCacheDaoConfiguration.class)
public class AuthorizerServiceConfiguration {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginCacheDao loginCacheDao;

    @Bean("authService")
    public AuthorizerService getService() {
        return new AuthorizerServiceImpl(userDao, loginCacheDao);
    }
}
