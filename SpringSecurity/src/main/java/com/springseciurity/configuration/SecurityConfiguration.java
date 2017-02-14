package com.springseciurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


// configuration of spring security
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// static user and admin data
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
		authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("root").password("root").roles("ADMIN");
	}
	
	// configure spring security
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
		.antMatchers("/", "/home").access("hasRole('USER') or hasRole('ADMIN')")
		.antMatchers("/admin").access("hasRole('ADMIN')")
        .and().formLogin().loginPage("/login")
        .usernameParameter("ssoId").passwordParameter("password")
        // access denied page
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
