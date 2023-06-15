package com.Student.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Entity.Student;
import com.Student.Repo.StudentRepo;
import com.Student.Service.StudentService;
import com.Student.custom.exception.EmptyInputException;
import com.Student.custom.exception.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;

	@Override
	public Student saveStudent(Student student) {
		if(student.getName().isEmpty() || student.getName().length()==0) {
			throw new EmptyInputException("601","Input fields are empty");
		}
		return repo.save(student);
	}

	@Override
	public Student getStudent(Integer id) {
		return repo.findById(id)
				.orElseThrow(()->new StudentNotFoundException("201","Student now found"));
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
		return "Student with " + existingStudent.getId() + " is saved";
	}

	@Override
	public Integer deleteStudent(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public List<Student> saveallstudents(List<Student> students) {
		List<Student> studentss = repo.saveAll(students);
		return studentss;
	}

}
