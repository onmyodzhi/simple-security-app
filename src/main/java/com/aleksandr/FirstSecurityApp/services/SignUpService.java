package com.aleksandr.FirstSecurityApp.services;

import com.aleksandr.FirstSecurityApp.models.Person;
import com.aleksandr.FirstSecurityApp.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SignUpService {

    private final PersonRepository personRepository;

    @Transactional
    public void signUp(Person person) {
        personRepository.save(person);
    }
}