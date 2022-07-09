package com.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.service.UserService;

@EnableWebSecurity
@Configuration
@ComponentScan({"com.springboot"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/product/viewAll").hasAnyAuthority("ROLE_ADMIN")
			.anyRequest().authenticated()
		    .and()
		.formLogin()
			.and()
		.httpBasic();
	}
	
	@Bean
	public UserService userDetailsService() {
	   return new UserService();
	};
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	};

}