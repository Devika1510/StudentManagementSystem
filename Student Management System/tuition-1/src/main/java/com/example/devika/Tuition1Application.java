package com.example.devika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.devika.model.Student;
import com.example.devika.repository.StudentRepository;

@SpringBootApplication
@ComponentScan("com.example")
public class Tuition1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Tuition1Application.class, args);
	}
	@Autowired
	private StudentRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student s1=new Student((long) 1,"Devika","Ramasamy","rdevika472@gmail.com");
		repo.save(s1);
		
	}

}
