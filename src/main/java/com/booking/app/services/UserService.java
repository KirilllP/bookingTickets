package com.booking.app.services;

import com.booking.app.entities.User;
import com.booking.app.exceptions.NoValidIdException;
import com.booking.app.exceptions.NotFoundException;
import com.booking.app.repositories.UserDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserService {
    //  https://www.baeldung.com/spring-transactional-propagation-isolation

    // https://stackoverflow.com/questions/4275111/correct-use-of-flush-in-jpa-hibernate

    // https://stackoverflow.com/questions/73125039/when-use-flush-with-jparepository
    private final UserDataJpaRepository repository;

    @Autowired
    public UserService(UserDataJpaRepository repository) {
        super();
        this.repository = repository;
    }

    @Transactional
    public List<User> allUsers() {
        return repository.findAll();
    }

    @Transactional
    public User addNewUser(User newUser) {
        return repository.save(newUser);
    }

    @Transactional
    public User findUserById(UUID id) {
        if (isUUIDvalid(id)) {
            return repository.findById(id).orElseThrow(() -> new NotFoundException("No such id: " + id));
        }
        throw new NoValidIdException("Invalid type of UUID");
    }

    @Transactional
    public User updateUser(UUID id, User updatedUser) {
        // https://javatute.com/spring-data-jpa/how-to-update-an-entity-using-spring-data-jpa/
        if (!isUUIDvalid(id)) {
            throw new NoValidIdException("Invalid type of UUID");
        }
        repository.findById(id).orElseThrow(() -> new NotFoundException("No such id: " + id));
        updatedUser.setId(id);
        return repository.save(updatedUser);
    }

    @Transactional
    public void deleteUserById(UUID id) {
        if (!isUUIDvalid(id)) {
            throw new NoValidIdException("Invalid type of UUID");
        }
        repository.findById(id).orElseThrow(() -> new NotFoundException("No such id: " + id));
        repository.deleteById(id);
    }

    private boolean isUUIDvalid(UUID id) {
        Pattern UUID_REGEX =
                Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        return UUID_REGEX.matcher(id.toString()).matches();
    }

}
