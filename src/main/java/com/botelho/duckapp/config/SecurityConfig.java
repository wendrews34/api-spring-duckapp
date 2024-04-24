package com.botelho.duckapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // URLs públicas permitidas sem autenticação
                .anyRequest().authenticated() // Todas as outras URLs requerem autenticação
                .and()
                .formLogin() // Configuração para formulário de login
                .loginPage("/login") // Página de login personalizada
                .permitAll() // Permite acesso à página de login
                .and()
                .logout() // Configuração para logout
                .permitAll(); // Permite logout para todos os usuários
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configura autenticação em memória (usuários hardcoded)
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password")) // Senha codificada com BCrypt
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("adminpassword")) // Senha codificada com BCrypt
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Utiliza BCryptPasswordEncoder para codificar senhas
        return new BCryptPasswordEncoder();
    }
}