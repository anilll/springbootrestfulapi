package com.freedom.financial.network.springbootrestapi.springsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.freedom.financial.network.springbootrestapi.controller.Controller;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    	logger.info("-------------Performing InMemory Authentication--------------");
    	auth.inMemoryAuthentication()
        .withUser("test").password("{noop}test123").roles("USER")
        .and()
        .withUser("admin").password("{noop}admin123").roles("ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		
		// http .authorizeRequests() .anyRequest() .authenticated() .and() .httpBasic();
    	http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/h2/**").permitAll();
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
    	
    	/*http.authorizeRequests()
        .antMatchers("/spring").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .permitAll()
        .and()
        .logout()
        .permitAll();*/
    }
}
