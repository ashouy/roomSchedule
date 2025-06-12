package com.jsoft.roomschedule.config.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    public static final String[] ENDPOINTS_WITH_AUTH_NOT_REQUIRED ={
            "/api/version"
    };
}
