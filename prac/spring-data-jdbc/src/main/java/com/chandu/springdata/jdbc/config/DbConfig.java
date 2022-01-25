package com.chandu.springdata.jdbc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DbConfig  {


    @Bean
    public DataSource mysqlDataSource() {
        var ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/ spring_database1");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
    }


}
