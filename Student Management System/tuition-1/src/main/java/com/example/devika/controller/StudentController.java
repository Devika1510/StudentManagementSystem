package com.example.devika.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.devika.model.Student;
import com.example.devika.service.StudentService;

@Controller
public class StudentController {

		private StudentService service;
	
		public StudentController(StudentService service) {
			super();
			this.service = service;
		}

		@GetMapping("/students")
		public String listStudents(Model model) {
			model.addAttribute("students",service.getAll());
			return "students";
		}
		
		@GetMapping("/students/new")
		public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
		}
		
		@PostMapping("/students")
		public String saveStudent(@ModelAttribute("student") Student student) { ///bind form  object to student entity
		service.saveStudent(student);
		return "redirect:/students";
		}
		
		@GetMapping("/students/edit/{id}")
		public String editStudentForm(@PathVariable Long id,Model model) {
			model.addAttribute("student",service.getStudentById(id));
			return "edit_student";
		}
		@PostMapping("/students/{id}")
		public String  studentUpdate(@PathVariable Long id,@ModelAttribute("student") Student student,Model model ) {
			Student existing=service.getStudentById(id);
			existing.setFirstName(student.getFirstName());
			existing.setLastName(student.getLastName());
			existing.setEmail(student.getEmail());
			service.updateStudent(existing);
			return"redirect:/students"
;		}
		//delete handler method
		@GetMapping("/students/{id}")
		public String deleteStudent(@PathVariable Long id) {
			service.deleteStudentById(id);
			return "redirect:/students";
		}
}
