package com.booking.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;


import java.sql.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    // https://habr.com/ru/companies/haulmont/articles/653843/
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_birth", nullable = false)
    private Date dateBirth;

    @Column(name = "passport_number", unique = true, nullable = false)
    private Integer passportNumber;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_security_id", referencedColumnName = "id")
    private UserSecurity security;
}
