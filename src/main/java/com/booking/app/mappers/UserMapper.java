package com.booking.app.mappers;

import com.booking.app.controllers.dto.RegistrationDTO;
import com.booking.app.controllers.dto.UserDTO;
import com.booking.app.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);

    RegistrationDTO toDTORegistration(User user);
    User toEntityRegistration(RegistrationDTO userDTO);
}
