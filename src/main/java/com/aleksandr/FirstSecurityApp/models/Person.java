package com.aleksandr.FirstSecurityApp.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "User name should be between 2 - 100 characters")
    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @Min(value = 1900, message = "year of birth should be more than 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }
}
