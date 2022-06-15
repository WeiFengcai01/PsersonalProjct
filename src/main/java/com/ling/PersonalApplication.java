package com.ling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@SpringBootApplication
@Configuration
@MapperScan("com.ling.mapper")
public class PersonalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonalApplication.class,args);
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }

}
