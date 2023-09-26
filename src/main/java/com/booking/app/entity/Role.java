package com.booking.app.entity;

import com.booking.app.enums.EnumPermission;
import com.booking.app.enums.EnumRole;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Enumerated
    private EnumRole role;
    @Column
    private Set<EnumPermission> privileges;



}
