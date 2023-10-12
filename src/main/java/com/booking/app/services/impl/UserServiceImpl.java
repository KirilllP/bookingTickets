package com.booking.app.services.impl;

import com.booking.app.controller.dto.UserDTO;
import com.booking.app.entity.User;
import com.booking.app.exceptionhandling.exception.ResourceNotFoundException;
import com.booking.app.mapper.UserMapper;
import com.booking.app.repositories.UserDataRepository;
import com.booking.app.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserDataRepository repository;


    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserDataRepository repository) {
        this.mapper = userMapper;
        this.repository = repository;
    }


    @Override
    public UserDTO create(UserDTO userDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getById(UUID id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user by ID: " + id));
        return mapper.toDTO(user);
    }

    @Override
    public UserDTO update(UUID id, UserDTO updated) {
        User user = mapper.toEntity(updated);
        user.setId(id);
        return mapper.toDTO(repository.save(user));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteUserById(id);
    }





}