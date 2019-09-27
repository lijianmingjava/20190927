package com.lanxin.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@SpringBootApplication
@ComponentScan(basePackages = {"com.lanxin"})
@MapperScan(basePackages = {"com.lanxin.dao"})
@EntityScan(basePackages = {"com.lanxin.bean"})
public class Start extends WebMvcConfigurerAdapter {

    //main start
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}
