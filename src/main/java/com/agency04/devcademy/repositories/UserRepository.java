package com.agency04.devcademy.repositories;

import com.agency04.devcademy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
