package ru.ramazanov.UrbanWheels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ramazanov.UrbanWheels.models.User;
import ru.ramazanov.UrbanWheels.repositories.UserRepository;
import ru.ramazanov.UrbanWheels.util.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> findingUser = repository.getUserById(id);
        if (findingUser.isEmpty()) {
            throw new UserNotFoundException("User with entered id is not found!");
        }
        return findingUser.get();
    }
    public void createUser(User user) {
        repository.save(user);
    }

    public void deleteUserById(int id) {
        Optional<User> findingUser = repository.getUserById(id);
        if (findingUser.isEmpty()) {
            throw new UserNotFoundException("User with entered id is not found!");
        }
        repository.deleteById(id);
    }
}
