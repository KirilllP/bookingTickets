package com.booking.app.controller;


import com.booking.app.controller.api.UserAuthAPI;
import com.booking.app.controller.dto.SecurityDTO;
import com.booking.app.controller.dto.ResponseDTO;
import com.booking.app.exceptionhandling.exception.UserAlreadyExistAuthenticationException;
import com.booking.app.services.UserSecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
@AllArgsConstructor
public class SignUpController implements UserAuthAPI {

    private final UserSecurityService service;

    @PreAuthorize("hasRole(USER)")
    @PostMapping
    @Override
    public ResponseDTO<SecurityDTO> signUp(@ModelAttribute("user") @RequestBody SecurityDTO dto) throws UserAlreadyExistAuthenticationException {
        return new ResponseDTO<>(service.register(dto));
    }


    @GetMapping

    @Override
    public ResponseDTO<SecurityDTO> signIn(SecurityDTO dto) {
        return null;
    }

}
