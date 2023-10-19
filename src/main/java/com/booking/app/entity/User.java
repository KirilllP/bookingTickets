package com.booking.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name = "registration_date")
    @CreatedDate
    private LocalDate registrationDate;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "role_id")
    private Role role;



    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private UserSecurity security;


}
