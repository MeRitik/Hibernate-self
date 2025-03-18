package com.hib.oneToMany.repository;

import com.hib.oneToMany.entities.Course;
import com.hib.oneToMany.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findByInstructorId(Integer id);
}
