package com.booking.app.controller;

import com.booking.app.entities.User;
import com.booking.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@Slf4j
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        super();
        this.service = service;
    }

    @GetMapping("/users")
    List<User> all() {
        return service.allUsers();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return service.addNewUser(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable UUID id) {
        return service.findUserById(id);
    }

    @PutMapping("/users/{id}")
    User updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
        return service.updateUser(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable UUID id) {
        service.deleteUserById(id);
    }
}
