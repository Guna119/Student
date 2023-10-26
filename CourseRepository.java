package com.example.studentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentManagement.Domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
//DTO and DAO
}
