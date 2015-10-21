/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 *
 * @author stasiuk-ps
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            
            .authorizeRequests()
                .antMatchers("/", "/home", "/registration", "/uploads/**", "/note/save", "/note/list", "/angularjs/**", "/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
                .antMatchers("/home").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
            .csrf().disable();
    }
    
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"SELECT username,password,'true' as enabled FROM users WHERE username = ?")
		.authoritiesByUsernameQuery(
			"SELECT username, authority as authorities FROM authorities WHERE username = ?");
    }
}
    

