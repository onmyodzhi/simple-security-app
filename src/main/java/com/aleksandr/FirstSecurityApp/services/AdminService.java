package com.aleksandr.FirstSecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ROLE_ADMIN')") // if need more then 1 role use hasRole('ROLE_ADMIN') or/and
    public void doAdminStuff(){
        System.out.println("Only admin here");
    }
}
