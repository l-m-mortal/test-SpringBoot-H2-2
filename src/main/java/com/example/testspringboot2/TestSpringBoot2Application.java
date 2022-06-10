package com.example.testspringboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class TestSpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBoot2Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostConstruct
    public void initDB() {
        jdbcTemplate.update("create table if not exists jokes (joke text)");
    }
}
