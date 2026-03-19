package com.sot.springTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public String customBean(){
        return "custom bean";
    }
}
