package com.example.devika.service;

import java.util.List;

import com.example.devika.model.Student;

public interface StudentService {
	List<Student> getAll();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
