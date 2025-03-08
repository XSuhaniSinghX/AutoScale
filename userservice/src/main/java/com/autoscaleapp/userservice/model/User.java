package com.autoscaleapp.userservice.model;

// (the comments are for my personal reference , i tend to forget how i do stuff.)
//so this is going to be first thing i code here, in this class, i will just be cresting a user entity
//sorry y'all, i am a bit of a yapper


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")  //the table used ti store users in db is called users (wow i am a genius)
public class User {
    
    @Id // id is going to be my primary key 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //should've used int caz this thing will only have probably 3 users
    
    @Column(nullable = false, unique = true)// cybersecurity at it's peak
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false, unique = true)
    private String email;
}
