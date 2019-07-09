package com.pi.birthday.repository;

import com.pi.birthday.login.ColleagueUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ColleagueUser, Long> {
    ColleagueUser findByUsername(String username);
}
