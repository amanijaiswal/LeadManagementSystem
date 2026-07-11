package com.cfs.leadmanagementapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.*;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration configuration=new CorsConfiguration();

        configuration.addAllowedOrigin("*");

        configuration.addAllowedHeader("*");

        configuration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source=
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",configuration);

        return source;

    }

}