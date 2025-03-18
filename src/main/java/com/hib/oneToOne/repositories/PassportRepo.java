package com.hib.oneToOne.repositories;

import com.hib.oneToOne.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Integer> {
}
