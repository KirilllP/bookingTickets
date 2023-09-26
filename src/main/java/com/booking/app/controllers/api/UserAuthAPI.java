package com.booking.app.controllers.api;


import com.booking.app.controllers.dto.RegistrationDTO;
import com.booking.app.controllers.dto.ResponseDTO;
import com.booking.app.controllers.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
public interface UserAuthAPI {

    @Operation(summary = "Register User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully")
    })
    ResponseDTO<RegistrationDTO> registerUser(@NotNull RegistrationDTO dto);
}
