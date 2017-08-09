package com.jennilyn.config;

import com.jennilyn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login/**").permitAll()
                    .antMatchers("/movie/edit/**").hasRole("USER")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .successHandler(loginSuccessHandler())
                    .failureHandler(loginFailureHandler())
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login");

    }

    private AuthenticationSuccessHandler loginSuccessHandler() {
        return (request, response, authentication) -> response.sendRedirect("/");
    }

    private AuthenticationFailureHandler loginFailureHandler() {
        return (request, response, exception) -> {
            request.getSession().setAttribute("error", "Unable to log in with provided credentials.");
            response.sendRedirect("/login");
        };
    }


}
