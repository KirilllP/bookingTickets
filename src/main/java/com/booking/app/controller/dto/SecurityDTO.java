package com.booking.app.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class SecurityDTO {
    private UUID id;

    @NotBlank(message = "Invalid Login: Empty login")
    @NotNull(message = "Invalid Login: Login is NULL")
    @Size(min = 5, max = 30, message = "Invalid Login: Must be of 5 - 30 characters")
    private final String username;

    @NotBlank(message = "Invalid Password: Empty password")
    @NotNull(message = "Invalid Password: Password is NULL")
    @Size(min = 8, max = 30, message = "Invalid Password: Must be of 8 - 30 characters")
    private final String password;

    @NotNull(message = "Invalid Email: Email is NULL")
    @Email(message = "Invalid email: This is not a valid email format")
    private final String email;

   // @Valid Это запускает проверку вложенного объекта
    private final UserDTO user;


}


