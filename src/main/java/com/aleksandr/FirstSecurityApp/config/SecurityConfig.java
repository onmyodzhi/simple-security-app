package com.aleksandr.FirstSecurityApp.config;

import com.aleksandr.FirstSecurityApp.services.PeopleDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    Code in comment will use only when you need to make default authentication
     */
    //private final AuthProviderImpl authProvider;
    private final PeopleDetailsService peopleDetailsService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.authenticationProvider(authProvider);
        auth.userDetailsService(peopleDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
