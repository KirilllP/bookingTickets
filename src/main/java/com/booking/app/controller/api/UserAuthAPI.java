package com.booking.app.controller.api;


import com.booking.app.controller.dto.SecurityDTO;
import com.booking.app.controller.dto.ResponseDTO;
import com.booking.app.controller.dto.UserDTO;
import com.booking.app.exceptionhandling.exception.UserAlreadyExistAuthenticationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserAuthAPI {

    @Operation(summary = "Register User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully")
    })
    ResponseDTO<SecurityDTO> signUp(@NotNull SecurityDTO dto) throws UserAlreadyExistAuthenticationException;


    @Operation(summary = "Authentication User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has been authenticated")
    })
    ResponseDTO<SecurityDTO> signIn(@NotNull SecurityDTO dto);

}
