package top.sob.auth.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import top.sob.auth.test.spring.controller.TestController;

public class TestMain {
    @Test
    public void test() throws InterruptedException {
        SpringApplication.run(TestController.class);
        Thread.sleep(20000);
    }
}
