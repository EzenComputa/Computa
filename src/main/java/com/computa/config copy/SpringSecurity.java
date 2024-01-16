package com.computa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // The filterChain method takes an HttpSecurity object as a parameter. HttpSecurity is a builder
    // provided by Spring Security that is used to create a security filter chain. A security filter chain is 
    // essentially a chain of filters that are applied to the incoming HTTP requests. Each filter in the chain
    // has a specific job, such as authenticating the user, checking the user's roles, handling exceptions, etc.
    // SecurityFilterChain is an interface provided by Spring Security that represents a security filter chain.
    // SecurityFilterChain is an interface but in this context, it is not directly dealing with a class that implements it.
    // The important thing is that http.build() returns a SecurityFilterChain that is configured according to the settings
    // specificed on the HttpSecurity object. There is no need for dependency injection here because the HttpSecurity
    // builder takes care of creating the SecurityFilterChain for you.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // http.crsf().disable() is a config in Spring Security that disables Cross-Site Request Forgery protection.
        // CRSF is an attack that tricks the victim into submitting a malicious request. It is disabled here. 
        // In a traditional web application, once a user logs in, a session is created on the server side. 
        // The server then sends a session ID to the client, usually in the form of a cookie. For each subsequqent request,
        // the client sends this session ID back to the server, and the server uses it to look up the session and identify
        // the user. This is known as stateful authenticaion because the server needs to maintain state (session) between requests.
        // In a REST API, however, it's common to use stateless authentication. This means, the server doesn't maintain any
        // state between requests. Instead, each request from the client includes all the information the server needs to 
        // authenticate the user and process the request. This is typically done using tokens. 
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**").permitAll() // anybody can access /register/**
                                .requestMatchers("/index","/","","/cpus","/gpus","/general_questions").permitAll() // anybody can access 
                                .requestMatchers("/wishlist/**", "/product/**", "/profile", "/user/**", "/buy_sell", "/postDetails/**","/writePost/**","/support_tickets", "/savePost", "/saveComment").hasRole("USER") // only users with USER role can access /wishlist
                                .requestMatchers("/users", "/support_tickets").hasRole("ADMIN") // only users with ADMIN role can access /users
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login") // url for login form's POST request 
                                .defaultSuccessUrl("/users") // If user successfully logs in, redirect to /users
                                .permitAll() // This is necessary because users need to be able to access these URLs before they're authenticated
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build(); // The filterChain method returns a SecurityFilterChain object. 
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth                                            // In this project, loadUserByUsername() method has a custom implementation
                .userDetailsService(userDetailsService) // Spring automatically injects the CustomUserDetailsService bean herec
                .passwordEncoder(passwordEncoder());
    }
}