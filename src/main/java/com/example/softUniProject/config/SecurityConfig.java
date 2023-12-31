package com.example.softUniProject.config;

import com.example.softUniProject.repo.UserRepository;
import com.example.softUniProject.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${keyys.remember-me.key}")
    private final String rememberMeKey;
    public SecurityConfig(@Value("${keyys:remember-me:key:}") String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/", "/login", "/register", "/login-error", "chooseWhatToDo").permitAll()
                .requestMatchers("/createAStory").permitAll()
                .requestMatchers("/story/read").permitAll()
                .requestMatchers("/images/**").permitAll()
                .anyRequest().authenticated()

        ).formLogin(
                formLogin -> {
                    formLogin.loginPage("/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/chooseWhatToDo", true)
                            .failureForwardUrl("/login-error");
                }
        ).logout(logout -> {
            logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true);
        }).rememberMe(rememberMe -> {
            rememberMe.key(rememberMeKey)
                    .rememberMeParameter("remember-me")
                    .rememberMeCookieName("remember-me-cookie");
        });

        return httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new MyUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
