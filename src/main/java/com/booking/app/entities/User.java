package com.booking.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_birth", nullable = false)
    private Date dateBirth;

    @Column(name = "passport_number", unique = true, nullable = false)
    private Integer passportNumber;

    @Column(name = "registraton_date", nullable = false)
    private Date registrationDate;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private UserSecurity security;
}
