package com.aleksandr.FirstSecurityApp.controllers;

import com.aleksandr.FirstSecurityApp.models.Person;
import com.aleksandr.FirstSecurityApp.services.SignUpService;
import com.aleksandr.FirstSecurityApp.util.PersonValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AuthController {

    private final SignUpService signUpService;
    private final PersonValidator personValidator;

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/sign_up")
    public String signUpPage(@ModelAttribute("person") Person person){
        return "auth/sign_up";
    }

    @PostMapping("/sign_up")
    public String performSignUp(@ModelAttribute("person") @Valid Person person,
                                BindingResult bindingResult){
        personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors()){
            return "auth/sign_up";
        }

        signUpService.signUp(person);

        return "redirect:/auth/login";
    }
}
