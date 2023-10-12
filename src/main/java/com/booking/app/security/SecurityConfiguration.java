package com.booking.app.security;

import com.booking.app.services.impl.UserSecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
    private final UserSecurityServiceImpl userServiceSecurityImpl;

    @Autowired
    public SecurityConfiguration(UserSecurityServiceImpl userSecurityServiceImpl) {
        this.userServiceSecurityImpl = userSecurityServiceImpl;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return http.csrf().disable().authorizeHttpRequests().anyRequest().permitAll().and().build();


//        return http
                //.cors(Customizer.withDefaults())
//                .csrf().disable()
//                .authorizeHttpRequests().requestMatchers("/signup").permitAll()
//                .and().authorizeHttpRequests().requestMatchers("/api/v1/users/**").authenticated()
//                .and().formLogin().and().build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
