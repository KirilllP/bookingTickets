package com.booking.app.controllers.dto;

import com.booking.app.entity.UserSecurity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class UserDTO {

    @NotNull
    @org.hibernate.validator.constraints.UUID
    private UUID id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @Past
    private Date dateBirth;

    @NotNull
    @Positive
    private Integer passportNumber;

    @NotNull
    @Past
    private Date registrationDate;

    @NotBlank
    private String phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    private UserSecurity security;
}
