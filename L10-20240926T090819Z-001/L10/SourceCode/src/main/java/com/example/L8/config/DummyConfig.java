package com.example.L8.config;


import lombok.SneakyThrows;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
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
     *      context -->
     *
     *      Scope
     *          singleton
     *      Scope
     *          prototype (application context is made (a new bean is returned))
     *
     *
     *
     *              *
     */

    @Bean
    @Scope("prototype")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @SneakyThrows
    @Bean
    public Connection connection(){
       return DriverManager.
               getConnection("jdbc:mysql://localhost:3306/JBDL_74", "root", "");
    }

    /**
     *  injected with help of application properties
     *
     *
     */
//    @Bean
//    public DataSource dataSource(){
//        return DataSourceBuilder.create()
//                .url("jdbc:mysql://localhost:3306/JBDL_74")
//                .username("root")
//                .password("").build();
//    }

}
