package com.booking.app.controller;


import com.booking.app.controller.api.UserAuthAPI;
import com.booking.app.controller.dto.SecurityDTO;
import com.booking.app.controller.dto.ResponseDTO;
import com.booking.app.controller.dto.UserDTO;
import com.booking.app.exceptionhandling.exception.UserAlreadyExistAuthenticationException;
import com.booking.app.services.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/")
public class UserRegistrationController implements UserAuthAPI {

    private final UserSecurityService service;

    @Autowired
    public UserRegistrationController(@Qualifier("userSecurityServiceImpl") UserSecurityService service) {
        this.service = service;
    }
   // @PreAuthorize("hasRole(USER)")
    @PostMapping("/signup")
    @Override
    public ResponseDTO<SecurityDTO> signUp(@RequestBody SecurityDTO dto) throws UserAlreadyExistAuthenticationException {
        return new ResponseDTO<>(service.register(dto));
    }


    @Override
    public ResponseDTO<SecurityDTO> signIn(SecurityDTO dto) {
        return new ResponseDTO<>();
    }

}
