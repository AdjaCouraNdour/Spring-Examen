package com.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permet à ton frontend Angular d'accéder à ton backend
        registry.addMapping("/**") // Applique les règles à toutes les requêtes
                .allowedOrigins("http://localhost:4200") // L'URL de ton frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes autorisées
                .allowedHeaders("*") // Autoriser tous les headers
                .allowCredentials(true); // Si tu utilises des cookies/session
    }
}
