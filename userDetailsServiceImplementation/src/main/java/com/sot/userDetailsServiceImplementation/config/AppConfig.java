package com.sot.userDetailsServiceImplementation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager customUserDetailsService = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("username")
                .password("Aa12345678")
                .authorities("read")
                .build();
        customUserDetailsService.createUser(user);
        return customUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
