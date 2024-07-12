package ru.ramazanov.UrbanWheels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ramazanov.UrbanWheels.models.User;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(int id);
}
