package com.authenticationproxy.authenticationproxy.security;

import com.authenticationproxy.authenticationproxy.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    UserDetailsService userDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(16);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userDetailsService);
        provider.setPasswordEncoder(this.passwordEncoder());
        return provider;
    }

    public String devGetEncryptedPassword(String password) { // REMOVE THIS FOR PRODUCTION!!! THIS IS TO MANUALLY ADD PASSWORDS TO THE DATABASE FOR TESTING
        return this.passwordEncoder().encode(password);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .csrf(cors -> cors.disable())
                .authorizeHttpRequests((requests) -> requests
                        // Allow anyone to access the root and index routes, and any routes that start with /static/
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/", "index.html").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
//                        .loginPage("/login") // Depricated and caused a redirect loop, keeping commented out to remind to find an alternative
//                        .loginProcessingUrl("/process-login") // does nothing at the moment, for if you want a seperate page for loading?
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/?error=true")
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout").permitAll()
                )
                .authenticationProvider(this.authenticationProvider());
        return http.build();
    }
}
