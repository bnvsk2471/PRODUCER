package com.Student.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Student.Entity.Student;
import com.Student.Repo.StudentRepo;
import com.Student.Service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepo repo;

	@Override
	public Student saveStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		Optional<Student> student=repo.findById(id);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public String updateStudent(Student student) {
		Student existingStudent = repo.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setEmail(student.getEmail());
		repo.save(existingStudent);
		return "Student with "+existingStudent.getId()+" is saved";
	}

	@Override
	public Integer deleteStudent(Integer id) {
		repo.deleteById(id);
		return id;
	}

}
