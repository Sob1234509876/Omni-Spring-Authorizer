package top.sob.xxx.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sob.xxx.spring.configuration.XXXServiceConfiguration;
import top.sob.xxx.spring.service.XXXService;

@SpringBootApplication
@EnableFeignClients
@RestController
@Import(XXXServiceConfiguration.class)
@RequestMapping("/api/xxx")
public class XXXController {
    @Autowired
    XXXService service;
}
