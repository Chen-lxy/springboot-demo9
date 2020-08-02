package com.chen.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chen.study.mapper")
public class SpringbootDemo9Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo9Application.class, args);
    }

}
