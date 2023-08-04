package ru.kata.spring.boot_security.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class CreateUserDefault {

    private UserDAO userDAO;
    private RoleDAO roleDAO;

    @Autowired
    public CreateUserDefault(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Bean
    public void createDef() {

        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleDAO.saveRole(adminRole);
        roleDAO.saveRole(userRole);

        Set<Role> adminSet = new HashSet<>();
        adminSet.add(adminRole);
        adminSet.add(userRole);
        Set<Role> userSet = new HashSet<>();
        userSet.add(userRole);

        User user = new User("user","user", userSet, 35);
        User admin = new User("admin","admin", adminSet, 99);

        userDAO.save(user);
        userDAO.save(admin);

    }
}
