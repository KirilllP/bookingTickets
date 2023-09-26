package com.booking.app.controller;

import com.booking.app.controller.api.UserAPI;
import com.booking.app.controller.dto.ResponseDTO;
import com.booking.app.controller.dto.UserDTO;
import com.booking.app.entity.User;
import com.booking.app.services.UserService;
import com.booking.app.services.impl.UserServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@Slf4j
public class UserController implements UserAPI {

    private final UserService service;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    @Override
    public ResponseDTO<UserDTO> getByID(@PathVariable UUID id) {
        return ResponseDTO.<UserDTO>builder().data(service.getById(id)).build();
    }

    @GetMapping("/get")
    @Override
    public ResponseDTO<List<UserDTO>> getAll() {
        return ResponseDTO.<List<UserDTO>>builder().data(service.getAll()).build();
    }

    @PutMapping("/put/{id}")
    @Override
    public ResponseDTO<UserDTO> update(@PathVariable UUID id, @RequestBody UserDTO user) {
        return ResponseDTO.<UserDTO>builder().data(service.update(id, user)).build();
    }

    @PostMapping("/create")
    @Override
    public ResponseDTO<UserDTO> create(@RequestBody UserDTO userDTO) {
        return ResponseDTO.<UserDTO>builder().data(service.create(userDTO)).build();
    }


    @DeleteMapping("/delete/{id}")
    @Override
    public void delete(@PathVariable UUID id) {
       service.delete(id);
    }
}
