package com.booking.app.mapper;

import com.booking.app.controller.dto.SecurityDTO;
import com.booking.app.controller.dto.UserDTO;
import com.booking.app.entity.User;
import com.booking.app.entity.UserSecurity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Security;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserDTO toDTO(User user);

    public User toEntity(UserDTO userDTO);

    public SecurityDTO toDTORegistration(UserSecurity user);

    public UserSecurity toEntityRegistration(SecurityDTO userDTO);
}