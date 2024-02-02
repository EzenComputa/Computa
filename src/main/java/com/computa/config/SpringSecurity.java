package com.computa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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
        public static PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http.csrf().disable()
                                .authorizeHttpRequests((authorize) -> authorize.requestMatchers("/register/**")
                                                .permitAll() // anybody can access /register/**
                                                .requestMatchers("/login", "/index", "/", "", "/product/**",
                                                                "/product_details", "/addProduct/**", "/saveProduct/**",
                                                                "/find_user", "/findpw/**", "/newpw/**", "/findid/**")
                                                .permitAll() // anybody can access
                                                .requestMatchers("/wishlist/**", "/product/**", "/profile", "/user/**",
                                                                "/postDetails/**", "/writePost/**", "/savePost",
                                                                "/saveComment", "/saveProductComment", "/uploadImage",
                                                                "/images/**", "/uploadCommentImage", "/myMain",
                                                                "/likeProd", "/usedMyshop", "/myQnaList", "/myTeabag")
                                                .hasRole("USER") // only users with USER role can access
                                                .requestMatchers("/manage_users").hasRole("ADMIN") // only users with
                                                                                                   // ADMIN role can
                                                                                                   // access /users
                                ).formLogin(
                                                form -> form
                                                                .loginPage("/login")
                                                                .loginProcessingUrl("/login") // url for login form's
                                                                                              // POST request
                                                                .defaultSuccessUrl("/index", true) // If user
                                                                                                   // successfully logs
                                                                                                   // in, redirect to
                                                                                                   // /index
                                                                .permitAll() // This is necessary because users need to
                                                                             // be able to access these URLs before
                                                                             // they're authenticated
                                ).logout(
                                                logout -> logout
                                                                .logoutRequestMatcher(
                                                                                new AntPathRequestMatcher("/logout"))
                                                                .permitAll());
                return http.build(); // The filterChain method returns a SecurityFilterChain object.
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth // In this project, loadUserByUsername() method has a custom implementation
                                .userDetailsService(userDetailsService) // Spring automatically injects the
                                                                        // CustomUserDetailsService bean herec
                                .passwordEncoder(passwordEncoder());

        }

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
                return (web) -> web.ignoring()
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                                .requestMatchers("/javax.faces.resource/**");
        }

}