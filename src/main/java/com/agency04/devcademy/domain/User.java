package com.agency04.devcademy.domain;

import com.agency04.devcademy.dto.request.UserCreateDto;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Email(message = "{email.user.email}")
    private String email;

    private String password;
    private boolean enabled;
    private boolean tokenExpired;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;


    private static Logger log = LoggerFactory.getLogger(User.class);

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    @PrePersist
    private void prePersist(){
        log.info("PrePersist --- First name: " + firstName + ", Last name: " + lastName + ", E-mail: " + email + ", Reservations: " + reservations);
    }
    @PreUpdate
    private void preUpdate(){
        log.info("PreUpdate --- First name: " + firstName + ", Last name: " + lastName + ", E-mail: " + email + ", Reservations: " + reservations);
    }
}
