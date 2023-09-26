package com.booking.app.security;

import com.booking.app.services.impl.UserServiceSecurityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

    private final UserServiceSecurityImpl userServiceSecurityImpl;

    @Autowired
    public SecurityConfiguration(UserServiceSecurityImpl userServiceSecurityImpl) {
        this.userServiceSecurityImpl = userServiceSecurityImpl;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                //.cors(Customizer.withDefaults())
                .csrf().disable()
                .authorizeHttpRequests()
                        .anyRequest().permitAll().and().build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
