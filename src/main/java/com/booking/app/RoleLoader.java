package com.booking.app;

import com.booking.app.entity.Role;
import com.booking.app.enums.EnumRole;
import com.booking.app.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleLoader implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = Role.builder().role(EnumRole.USER).build();
        Role roleAdmin = Role.builder().role(EnumRole.ADMIN).build();
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
    }
}
