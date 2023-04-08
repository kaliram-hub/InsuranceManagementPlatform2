package com.imt.care.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder encoder() { return new BCryptPasswordEncoder();}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.builder()
				.username("kaliram")
				.password(encoder().encode("kaliram"))
				.roles("ADMIN") 
				.build();
		return new InMemoryUserDetailsManager(user1);
	}

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http.csrf().disable()
	                .authorizeHttpRequests()
	                .and()
	                .authorizeHttpRequests()
	                .anyRequest()
	                //.requestMatchers("/api/clients/**")
	                .authenticated().and().httpBasic().and().build();
	    }


}
