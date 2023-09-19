package com.booking.app.repositories;

import com.booking.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserDataJpaRepository extends JpaRepository<User, Serializable> {
}
