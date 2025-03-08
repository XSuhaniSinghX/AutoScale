package com.autoscaleapp.userservice.repository;
// step 2 right here
//this one will handle crud operations 

import com.autoscaleapp.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;//main stuff, will handle all crud ops.
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);//giving both options caz i am cool.
}
