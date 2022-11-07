package com.example.rschircoursework.security;

import com.example.rschircoursework.services.impl.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserServiceImpl userService;

    public WebSecurityConfig(UserServiceImpl userService) {
        this.userService = userService;
    }

    // TODO: 05.05.2022 переделать как у себя в паттернах
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf()
                    .disable()
                    .cors()
                    .disable()
                    .authorizeRequests()
                    .antMatchers("/user/home","/user/products").permitAll()//стартовая страница
                .antMatchers("/shopping_basket/*","/logout","/item/name","/order/owner","/orderDetail/*").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/pet/*", "/item/*","/item_type/*","/user/*","/brand/*","/order/*").hasAnyAuthority("ADMIN")
                    .antMatchers( "/sign").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").failureUrl("/login-error").defaultSuccessUrl("/user/home").permitAll().
                and()
                    .logout().logoutSuccessUrl("/user/home").
                and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .sessionFixation().migrateSession();
    }
}
