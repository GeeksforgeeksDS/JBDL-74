package com.example.L8.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/v2")
public class SampleController {

    @Autowired
    RestTemplate restTemplate;


    /*
        DispatcherServlet

                --> how does it identifies routes --->

                @Component
                    --> Controller , Service,  Respository , Configuration

      DispatcherServlet
                    -----> identifies beans marked @Controller/ @RestController
                    --> routes are identified unique route is identified [HTTP METHOD + API END POINT]



     */

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() {
//        RestTemplate restTemplate = dummyConfig.restTemplate();
        log.error(" rest Template {} ", restTemplate);
        return restTemplate.getForObject("https://picsum.photos/id/237/200/300", byte[].class);

    }

}
