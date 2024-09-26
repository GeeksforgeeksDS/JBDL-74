package com.example.L8.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        Object user_controller_v2 = applicationContext.getBeanFactory().getBean("USER_CONTROLLER_V2");
        log.info("Bean created {} ", user_controller_v2);
//        log.info(String.valueOf(Arrays.asList(applicationContext.getBeanDefinitionNames())));
    }
}
