package com.booking.app.services;

import com.booking.app.controller.dto.SecurityDTO;
import com.booking.app.controller.dto.UserDTO;
import com.booking.app.exceptionhandling.exception.UserAlreadyExistAuthenticationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserSecurityService {
    @Transactional
    SecurityDTO register(SecurityDTO user) throws UserAlreadyExistAuthenticationException;
}
