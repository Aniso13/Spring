package com.anis.eazyschool.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class ProjectSecurityConfig {

    SecurityFilterChain defaultSecurityFilterChain (HttpSecurity http) throws Exception {

        // Permit All Requests inside the Web Application
        http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        // Deny All Requests inside the Web Application
            /*http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());*/

        return http.build();
    }
}
