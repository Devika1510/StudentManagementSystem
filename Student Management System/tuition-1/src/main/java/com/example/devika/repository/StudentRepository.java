package com.example.devika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devika.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
