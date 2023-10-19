package com.booking.app.controller.dto;

import com.booking.app.mapper.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@Valid
@Builder
public class UserDTO {

    @Pattern(regexp = "[A-Za-z]+", message = "Your first name can not be blank")
    private final String firstName;

    @Pattern(regexp = "[A-Za-z]+", message = "Your last name can not be blank")
    private final String lastName;
  //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") need to try that
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @Past(message = "You couldn't be born in the future")
    private final Date dateBirth;

    private final LocalDate registrationDate;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
    private final String phoneNumber;

    private final RoleDTO role;




}
