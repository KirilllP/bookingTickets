package com.booking.app.services.impl;

import com.booking.app.controller.dto.UserDTO;
import com.booking.app.entity.User;
import com.booking.app.mappers.UserMapper;
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
        return mapper.toDTO(repository.findById(id).get());
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


//!!mapstruct
//            @Mapper(componentModel = "spring")
//            public abstract class UserMapper {
//                private final Logger logger = LoggerFactory.getLogger(UserMapper.class);
//
//                @Mapping(source = "repoUser.name", target = "firstName")
//                @Mapping(source = "repoUser.surname", target = "lastName")
//                public abstract UserDto toDto(RepoUser repoUser);
//
//                @AfterMapping
//                public void setUuid(RepoUser repoUser, @MappingTarget UserDto userDto) {
//                    userDto.setUuid(String.valueOf(UUID.randomUUID()));
//                }
//            }
