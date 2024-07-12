package ru.ramazanov.UrbanWheels.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ramazanov.UrbanWheels.models.User;
import ru.ramazanov.UrbanWheels.services.UserService;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public UserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.getUserByEmail(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with entered Email not found!");
        }

        return new ru.ramazanov.UrbanWheels.security.UserDetails(optionalUser.get());
    }
}
