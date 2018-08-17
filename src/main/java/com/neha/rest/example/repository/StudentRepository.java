package com.neha.rest.example.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.neha.rest.example.model.Student;

@Repository
public class StudentRepository {

	Map<Long, Student> students = new HashMap();
	long currentId = 100;

	public Collection findAll() {
		return students.values();
	}

	public Optional<Student> findById(Long id) {
		Student s = null;
		if (students.containsKey(id)) {
			s = students.get(id);
		}
		return Optional.ofNullable(s);
	}
	
	public Student save(Student s){
		s.setId(++currentId);
		students.put(s.getId(), s);
		return s;
	}
	
	public Optional<Student> update(Student s){
		Student currentStudent = students.get(s.getId());
		if(currentStudent!=null){
			students.put(s.getId(), s);
			currentStudent=students.get(s.getId());
		}
		return Optional.ofNullable(currentStudent);
	}
	
	public Optional<Student> delete(Long id){
		Student currentStudent = students.get(id);
		if(currentStudent != null){
			students.remove(id);
		}
		return Optional.ofNullable(currentStudent);
	}

}
