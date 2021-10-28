package com.mohsinkd786.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GithubConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
