package com.booking.app.entity;

import com.booking.app.enums.EnumAuthority;
import com.booking.app.enums.EnumRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;


@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private EnumRole role;



    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<User> users;


}
