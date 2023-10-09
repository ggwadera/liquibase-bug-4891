package com.example.demo;

import liquibase.integration.spring.SpringLiquibase;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public SpringLiquibase liquibase1(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setShouldRun(true);
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:changelog1.xml");
        return liquibase;
    }

    // @Bean
    public SpringLiquibase liquibase2(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setShouldRun(true);
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:changelog2.xml");
        return liquibase;
    }

}
