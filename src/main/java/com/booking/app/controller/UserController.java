package com.booking.app.controller;

import com.booking.app.entities.User;
import com.booking.app.exceptions.ResponseStatusException;
import com.booking.app.repositories.UserRepository;
import com.booking.app.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Log4j2

public class UserController {

    private final UserService service;

    @GetMapping("/users")
    List<User> all(){
        return service.all();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser){
        return service.newUser(newUser);
    }

    @GetMapping("users/{id}")
    User one(@PathVariable Long id){
        return service.one(id);
    }

    @PutMapping("users/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        return service.updateUser(id, updatedUser);
    }

    @DeleteMapping("users/{id}")
    void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }


}
