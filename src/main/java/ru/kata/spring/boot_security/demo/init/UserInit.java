package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;


@Component
public class UserInit {
    private static Role userRole = new Role("ROLE_USER");
    private static Role adminRole = new Role("ROLE_ADMIN");
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserInit(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void init() {
        roleRepository.save(userRole);
        roleRepository.save(adminRole);
        User user = new User("user","user",22);
        user.getRoles().add(userRole);
        User admin = new User("admin", "admin", 88);
        admin.getRoles().add(userRole);
        admin.getRoles().add(adminRole);
    }
}
