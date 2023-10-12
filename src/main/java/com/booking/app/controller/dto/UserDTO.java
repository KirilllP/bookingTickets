package com.booking.app.controller.dto;

import com.booking.app.CustomDateDeserializer;
import com.booking.app.entity.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Builder
public class UserDTO {

    @Pattern(regexp = "[A-Za-z]+", message = "Your first name can not be blank")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]+", message = "Your last name can not be blank")
    private String lastName;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @Past(message = "You couldn't be born in the future")
    private Date dateBirth;

    private LocalDate registrationDate;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
    private String phoneNumber;

    private RoleDTO role;




}
