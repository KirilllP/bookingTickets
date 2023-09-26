package com.booking.app.controllers;


import com.booking.app.controllers.api.UserAuthAPI;
import com.booking.app.controllers.dto.RegistrationDTO;
import com.booking.app.controllers.dto.ResponseDTO;
import com.booking.app.controllers.dto.UserDTO;
import com.booking.app.services.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserAuthController implements UserAuthAPI {

    private final UserService service;

    @Autowired
    public UserAuthController(@Qualifier("userServiceImpl") UserService service) {
        this.service = service;
    }

    @Override
    public ResponseDTO<RegistrationDTO> registerUser(@NotNull RegistrationDTO dto){
        return ResponseDTO.<RegistrationDTO>builder().data(service.create(dto)).build();
    }
}
