package top.sob.xxx.spring.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("xxx-service")
@RequestMapping("/api/xxx")
public interface XXXClient {
}
