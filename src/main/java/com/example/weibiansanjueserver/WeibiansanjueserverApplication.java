package com.example.weibiansanjueserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.weibiansanjueserver.dao")
@ComponentScan(basePackages = {"com.example", "org.n3r.idworker"})
public class WeibiansanjueserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeibiansanjueserverApplication.class, args);
    }

}
