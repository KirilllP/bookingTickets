package com.booking.app.services;

import com.booking.app.entities.User;
import com.booking.app.exceptions.ResponseStatusException;
import com.booking.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public List<User> all(){
        return repository.findAll();
    }


    public User newUser( User newUser){
        newUser.getSecurity().setUser(newUser);
        return repository.saveAndFlush(newUser);
    }


    public User one( Long id){
        return repository.findById(id).orElseThrow(() ->new ResponseStatusException(id));
    }


    public User updateUser( Long id, User updatedUser){
        Optional<User> optionalUser = Optional.ofNullable(repository.findById(id).orElseThrow(() ->new ResponseStatusException(id)));
        return optionalUser.map(user ->{
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setPassportNumber(updatedUser.getPassportNumber());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setRegistrationDate(updatedUser.getRegistrationDate());
            user.setEmail(updatedUser.getEmail());
            user.setDateBirth(updatedUser.getDateBirth());
            return repository.save(user);
        }).get();
    }


    public void deleteUser( Long id){
        repository.deleteById(id);
    }

}
