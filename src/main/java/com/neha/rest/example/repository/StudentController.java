package com.neha.rest.example.repository;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neha.rest.example.exception.StudentNotFoundException;
import com.neha.rest.example.model.Student;

@RestController
public class StudentController {
	
	 private StudentRepository repository;
	
	@Autowired
	public void SudentController(StudentRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/students")
	Collection readStudents(){
		return (Collection) this.repository.findAll();
	}
	
	@GetMapping("/students/{id}")
	Student readStudent(@PathVariable Long id) {
		return (Student) this.repository.findById(id).orElseThrow(StudentNotFoundException::new);
	}
	
	@PostMapping("/students")
	ResponseEntity addStudent(@RequestBody Student student){
		Student result = this.repository.save(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/students")
	Student updateStudent(@RequestBody Student student){
		return (Student) this.repository.update(student).orElseThrow(StudentNotFoundException::new);
	}
	
	@DeleteMapping("/students/{id}")
	void deleteStudent(@PathVariable Long id){
		this.repository.delete(id).orElseThrow(StudentNotFoundException::new);
	}
}
