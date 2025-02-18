package top.sob.auth.spring.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("xxx-service")
@RequestMapping("/api/xxx")
public interface AuthorizerClient {
}
