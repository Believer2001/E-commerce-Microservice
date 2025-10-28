package enset.ma.gatewayservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        // ⬅️ L'ORIGIN de votre application Angular
        corsConfig.addAllowedOrigin("http://localhost:4200");

        // Ajoutez ici toutes les méthodes nécessaires
        corsConfig.addAllowedMethod("*"); // Ou .addAllowedMethod("GET", "POST", etc.)

        // Ajoutez ici tous les en-têtes nécessaires
        corsConfig.addAllowedHeader("*");

        // Important pour l'authentification et les cookies
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // Appliquer à toutes les routes

        return new CorsWebFilter(source);
    }
}
