package com.booking.app.repositories;

import com.booking.app.entity.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity,Serializable>{
    UserSecurity findByLogin(String name);
}
