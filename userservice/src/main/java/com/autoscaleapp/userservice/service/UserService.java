package com.autoscaleapp.userservice.service;

import com.autoscaleapp.userservice.model.User;
import com.autoscaleapp.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

//third step y'all.
// this one's the real business logic

import java.util.Optional;

@Service //real service. seperates business logic from controllers
//keeps code as clean as low taper fade
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } //for some reason they call it constructor injection 

    public User registerUser(User user) { // Registering a new user

        return userRepository.save(user);
    }//saving user here , well not exactly here, but in db

    public Optional<User> findByUsername(String username) { // To handle potential null pointer exceptions

        return userRepository.findByUsername(username);
    }
}
