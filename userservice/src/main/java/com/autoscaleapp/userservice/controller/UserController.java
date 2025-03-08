package com.autoscaleapp.userservice.controller;

import com.autoscaleapp.userservice.model.User;
import com.autoscaleapp.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//step 4
//the controller
//why did i make it AFTER registration part? because i wanted to. 


@RestController //of course this class is a rest api controller.
@RequestMapping("/api/users")//the endpoints
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")//for handling registration
    public ResponseEntity<User> registerUser(@RequestBody User user) {//this one runs when a post request is sent (need to write it down caz i am damn sure i'll forget this one.
    // (requestbody ) it takes jason data to convert it to java (i swear java should be named ohio instead)
    //takes a User object as input (sent from the frontend),saves it in the db (using UserService) ,Returns the saved user
    return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
