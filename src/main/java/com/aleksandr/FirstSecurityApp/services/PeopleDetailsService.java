package com.aleksandr.FirstSecurityApp.services;

import com.aleksandr.FirstSecurityApp.models.Person;
import com.aleksandr.FirstSecurityApp.repositories.PersonRepository;
import com.aleksandr.FirstSecurityApp.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PeopleDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);

        if (person.isPresent()) {
            return new PersonDetails(person.get());
        } else throw new UsernameNotFoundException("Login doesnt exist");
    }
}
