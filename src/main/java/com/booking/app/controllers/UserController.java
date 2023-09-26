package com.booking.app.controllers;

import com.booking.app.controllers.api.UserAPI;
import com.booking.app.controllers.dto.ResponseDTO;
import com.booking.app.controllers.dto.UserDTO;
import com.booking.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/users")
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
