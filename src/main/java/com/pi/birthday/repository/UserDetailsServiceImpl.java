package com.pi.birthday.repository;

import com.pi.birthday.login.ColleagueUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;


    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ColleagueUser appColleagueUser = userRepository.findByUsername(username);
        if(appColleagueUser == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(appColleagueUser.getUsername(), appColleagueUser.getPassword(), Collections.emptyList());
    }
}
