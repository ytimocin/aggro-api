package com.aggro.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by yeko on 16/10/15.
 */
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.aggro.api")
public class AggroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggroApiApplication.class, args);
    }
}
