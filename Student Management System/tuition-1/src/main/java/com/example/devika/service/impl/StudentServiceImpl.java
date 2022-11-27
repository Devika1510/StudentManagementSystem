package com.example.devika.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.devika.model.Student;
import com.example.devika.repository.StudentRepository;
import com.example.devika.service.StudentService;
@Service
public class StudentServiceImpl  implements StudentService{
	private StudentRepository repo;
	
	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Student> getAll() {
		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		repo.deleteById(id);
		
	}

}
