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
@NoArgsConstructor
@Builder
@Valid
public class SecurityDTO {
    private UUID id;

    @Pattern(regexp = "[A-Za-z]+", message = "Your login can not be blank")
    @NotBlank
    private String username;

    @Pattern(regexp = "[A-Za-z]+", message = "Your password can not be blank")
    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    private UserDTO user;


}


