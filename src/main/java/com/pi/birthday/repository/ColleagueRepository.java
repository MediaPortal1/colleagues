package com.pi.birthday.repository;

import com.pi.birthday.tables.Colleague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColleagueRepository extends JpaRepository<Colleague, Integer> {
}
