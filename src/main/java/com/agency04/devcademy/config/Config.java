package com.agency04.devcademy.config;

import com.agency04.devcademy.service.RoomAccommodationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@PropertySource("classpath:application-ara.properties")
@ImportResource("classpath:config.xml")
@Configuration
public class Config {

    @Value("${accommodation.owner}")
    private String accommodationOwner;

    @Value("${accommodation.owner.name}")
    private String accommodationOwnerName;

    @Value("${accommodation.owner.facebook}")
    private String accommodationOwnerFacebook;

    @Value("${accommodation.owner.instagram}")
    private String accommodationOwnerInstagram;

    @Bean("roomAccommodationService")
    RoomAccommodationService accommodationService() {
        return new RoomAccommodationService();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_USER";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }
    @Bean
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy());
        return expressionHandler;
    }
}
