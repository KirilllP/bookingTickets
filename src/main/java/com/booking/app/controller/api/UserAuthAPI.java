package com.booking.app.controller.api;


import com.booking.app.controller.dto.SecurityDTO;
import com.booking.app.controller.dto.ResponseDTO;
import com.booking.app.exceptionhandling.exception.UserAlreadyExistAuthenticationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Validated
public interface UserAuthAPI {

    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Register User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully"),
            @ApiResponse(responseCode = "409", description = "This login email already exists…"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    ResponseDTO<SecurityDTO> signUp(@Valid @NotNull SecurityDTO dto) throws UserAlreadyExistAuthenticationException;

    @Operation(summary = "Authentication User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has been authenticated")
    })
    ResponseDTO<SecurityDTO> signIn(@RequestBody @NotNull @Valid SecurityDTO dto);

}
