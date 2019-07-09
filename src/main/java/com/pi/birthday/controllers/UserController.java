package com.pi.birthday.controllers;

import com.pi.birthday.login.ColleagueUser;
import com.pi.birthday.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @PostMapping(value = "/sign-up", produces = "application/json")
    public boolean signUP(@RequestBody ColleagueUser colleagueUser){
        try {
            colleagueUser.setPassword(encoder.encode(colleagueUser.getPassword()));
            userRepository.save(colleagueUser);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
