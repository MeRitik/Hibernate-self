package com.hib.oneToMany.repository;

import com.hib.oneToMany.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {
}
