package com.booking.app.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.repository.CrudRepository;

@Data
@Entity
@Table(name = "user_security")
public class UserSecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(unique = true,nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "security")
    private User user;

}
