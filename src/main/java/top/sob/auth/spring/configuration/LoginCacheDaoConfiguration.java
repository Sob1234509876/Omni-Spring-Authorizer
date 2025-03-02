package top.sob.auth.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import top.sob.auth.spring.dao.redis.LoginCacheDao;
import top.sob.auth.spring.dao.redis.LoginCacheDaoImpl;

@Configuration
public class LoginCacheDaoConfiguration {

    public static final String DEFAULT_LOGIN_CACHE_NAME = "login-cache";

    @Autowired(required = false)
    String loginCacheName;

    @Autowired
    StringRedisTemplate redis;

    @Bean("loginCache")
    public LoginCacheDao getDao() {
        return new LoginCacheDaoImpl(redis, loginCacheName == null ? DEFAULT_LOGIN_CACHE_NAME : loginCacheName);
    }
}
