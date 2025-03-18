package com.hib.oneToMany.repository;

import com.hib.oneToMany.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findByInstructorId(Integer id);

    // Multiple JOIN FETCH can be added.
    @Query(value = "SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = ?1", nativeQuery = true)
    List<Course> getByInsId(Integer id);
}
