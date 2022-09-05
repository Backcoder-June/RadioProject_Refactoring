package com.example.radioclone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "member")
@MapperScan(basePackages = "board")
@ComponentScan(basePackages= "member")
@ComponentScan(basePackages= "board")
@ComponentScan
@SpringBootApplication
public class CloneRadioprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloneRadioprojectApplication.class, args);
    }

}
