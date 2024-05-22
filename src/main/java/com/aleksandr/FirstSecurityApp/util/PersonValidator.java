package com.aleksandr.FirstSecurityApp.util;

import com.aleksandr.FirstSecurityApp.models.Person;
import com.aleksandr.FirstSecurityApp.services.PeopleDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PersonValidator implements Validator {

    private final PeopleDetailsService peopleDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        try {
            peopleDetailsService.loadUserByUsername(person.getUsername());
        } catch (UsernameNotFoundException e) {
            return;
        }
        errors.rejectValue("username", "", "Username is already exist");
    }
}
