package ru.kata.spring.boot_security.demo.entities;




import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "The name field can contain only letters")
    @Size(min = 2, max = 45, message = "Name should be between 2 and 45 characters")
    private String name;

    @Column
    @NotEmpty(message = "Surname should not be empty")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "The surname field can contain only letters")
    @Size(min = 2, max = 45, message = "SurName should be between 2 and 45 characters")
    private String surname;

    @Column
    @NotNull
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @Column(unique = true)
    @NotEmpty
    private String username;

    @Column
    @NotEmpty
    private String password;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
