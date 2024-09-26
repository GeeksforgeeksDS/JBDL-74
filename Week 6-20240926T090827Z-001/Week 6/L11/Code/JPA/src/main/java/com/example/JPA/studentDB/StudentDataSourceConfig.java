package com.example.JPA.studentDB;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.JPA.studentDB",
entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanStudent",
transactionManagerRef = "studentTransactionManager")
public class StudentDataSourceConfig {


    public static final String STUDENT_DATASOURCE = "STUDENT_DATASOURCE";

    @Bean(value = STUDENT_DATASOURCE)
    @ConfigurationProperties(prefix = "student.datasource")
    DataSource studentDataSource(){
        return DataSourceBuilder.create().build();
    }





    @Bean
    public LocalContainerEntityManagerFactoryBean
    localContainerEntityManagerFactoryBeanStudent(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(studentDataSource());
        em.setPackagesToScan("com.example.JPA.studentDB");
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean
    public PlatformTransactionManager studentTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBeanStudent().getObject());
        return transactionManager;
    }


}