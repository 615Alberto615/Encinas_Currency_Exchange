package com.Encinas_Currency_Exchange.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class globalSecurityConfiguration  {
    private final KeycloakJWTTokensConverts keycloakJwtTokenConverts;

    public globalSecurityConfiguration (TokenConvertProperties properties) {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter
                = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverts
                = new KeycloakJWTTokensConverts (
                jwtGrantedAuthoritiesConverter,
                properties);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( (authorizeHttpRequests) -> {
            authorizeHttpRequests
                    .requestMatchers(HttpMethod.POST,"/api/conversions/convert").hasRole("admin")
                    .requestMatchers(HttpMethod.POST,"/api/conversions").hasRole("admin")
                    .requestMatchers(HttpMethod.DELETE,"/api/conversions/{id}").hasRole("user")
                    .requestMatchers(HttpMethod.GET,"/api/conversions/**").hasAnyRole("user")
                    .requestMatchers(HttpMethod.PUT,"/api/conversions/{id}").hasAnyRole("user")
                    .requestMatchers (HttpMethod.OPTIONS, "/**").permitAll()//extra xd
                    .anyRequest().denyAll();
        });
        http.oauth2ResourceServer ((oauth2) -> {
            oauth2.jwt( (jwt) -> jwt.jwtAuthenticationConverter (keycloakJwtTokenConverts));
        });
        http.sessionManagement((session) -> session.sessionCreationPolicy (SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
