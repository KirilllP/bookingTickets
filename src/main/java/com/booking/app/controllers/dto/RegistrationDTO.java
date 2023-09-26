package com.booking.app.controllers.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class RegistrationDTO {

    @NotBlank
    @Size(min = 6, message = "login must be 6 symbols or more")
    String login;

    @NotBlank
    @Size(min = 6, message = "password must be 6 symbols or more")
    String password;

    @NotBlank
    @Email
    String email;
}
