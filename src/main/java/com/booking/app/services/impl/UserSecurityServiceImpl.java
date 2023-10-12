package com.booking.app.services.impl;

import com.booking.app.controller.dto.SecurityDTO;
import com.booking.app.entity.Role;
import com.booking.app.entity.User;
import com.booking.app.entity.UserSecurity;
import com.booking.app.enums.EnumRole;
import com.booking.app.exceptionhandling.exception.UserAlreadyExistAuthenticationException;
import com.booking.app.mapper.UserMapper;
import com.booking.app.repositories.RoleRepository;
import com.booking.app.repositories.UserDataRepository;
import com.booking.app.repositories.UserSecurityRepository;
import com.booking.app.services.UserSecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.Optional;

@Service
public class UserSecurityServiceImpl implements UserDetailsService, UserSecurityService {

    private final UserSecurityRepository userSecurityRepository;
    private final RoleRepository roleRepository;
    private final UserDataRepository userDataRepository;
    private final UserMapper mapper;


    @Autowired
    public UserSecurityServiceImpl(UserSecurityRepository userRepository, RoleRepository roleRepository, UserDataRepository userDataRepository, UserMapper mapper) {
        this.userSecurityRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userDataRepository = userDataRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSecurity userSecurity = userSecurityRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
        return userSecurity;
    }


    @Override
    public SecurityDTO register(SecurityDTO securityDTO) throws UserAlreadyExistAuthenticationException {

        Optional<UserSecurity> userEntity = userSecurityRepository.findByUsernameOrEmail(securityDTO.getUsername(), securityDTO.getEmail());

        if (userEntity.isPresent()) {
            throw new UserAlreadyExistAuthenticationException("We’re sorry. This login email already exists…");
        }

        Role role = roleRepository.findByRole(EnumRole.USER);
        User user = new User();
        user.setRole(role);

        userEntity = Optional.of(mapper.toEntityRegistration(securityDTO));
        user.setSecurity(userEntity.get());
        user.getSecurity().setUser(user);


        UserSecurity userSecurityEntity = user.getSecurity();
        userSecurityEntity.setAccountNonExpired(true);
        userSecurityEntity.setAccountNonLocked(true);
        userSecurityEntity.setCredentialsNonExpired(true);
        userSecurityEntity.setEnabled(true);


        userDataRepository.save(user);


        return mapper.toDTORegistration(userSecurityEntity);
    }
}
