package ru.ramazanov.UrbanWheels.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ramazanov.UrbanWheels.models.User;
import ru.ramazanov.UrbanWheels.repositories.UserRepository;
@Component
public class UserValidator implements Validator {
    private UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userRepository.getUserByEmail(user.getEmail()).isPresent()) {
            User emailOwner = userRepository.getUserByEmail(user.getEmail()).get();
            if (user.getId() != emailOwner.getId()) {
                errors.rejectValue("email", null, "Email уже занят!");
            }
        }
    }
}
