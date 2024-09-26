package com.example.L8.config;


import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DummyConfig {


    /**
     * Spring identifies --> which java
     *
     * - @Component directly / in
     *
     *
     *
     *
     * @return
     *
     *          3 party call
     *
     * @Bean utilized
     *  --> bean of source code.
     *
     *  IOC --> creation of beans
     *
     *      application
     *          HashMap<"nameOfTheBean", instanceOfBean>
     *                 <restTemplate><$$restTemplate1>
     *              // or by the name that has been specified by the developer
     *
     *              <name , instance>
     *
     *
     *
     *
     *
     *
     *              *
     */

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @SneakyThrows
    @Bean
    public Connection connection(){
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/JBDL_74", "root", "");
    }

}
