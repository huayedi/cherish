package com.jxhx.cherish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author: 张韶杰
 * @date: 2020/1/7 20:19
 **/
@SpringBootApplication
@EnableSwagger2
public class CherishAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CherishAdminApplication.class, args);
    }

}
