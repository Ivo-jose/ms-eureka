package br.com.ivogoncalves.ms_eureka.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		  .csrf(csrf -> csrf.disable())
		  .authorizeHttpRequests(requests -> requests
				  .requestMatchers("/eureka/**").permitAll()
				  .anyRequest().authenticated())
		  .httpBasic(withDefaults());
	    return http.build();	
	}
}
