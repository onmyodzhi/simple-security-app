package com.aleksandr.FirstSecurityApp.security;

import com.aleksandr.FirstSecurityApp.services.PeopleDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AuthProviderImpl implements AuthenticationProvider {

    private final PeopleDetailsService peopleDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

        UserDetails personDetails = peopleDetailsService.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if (!password.equals(personDetails.getPassword())) {
            throw new BadCredentialsException("invalid password");
        }

        return new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
