package top.sob.auth.spring;

import org.springframework.context.annotation.Import;
import top.sob.auth.spring.configuration.AuthorizerConfiguration;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AuthorizerConfiguration.class)
public @interface EnableAuthorizer {
}
