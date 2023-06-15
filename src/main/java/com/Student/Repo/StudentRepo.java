package com.Student.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Entity.Student;



public interface StudentRepo extends JpaRepository<Student, Integer> {

}
