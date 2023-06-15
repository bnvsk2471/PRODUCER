package com.Student.Service;

import java.util.List;
import java.util.Optional;

import com.Student.Entity.Student;


public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public Student getStudent(Integer id);
	
	public List<Student> getAllStudents();
	
	public String updateStudent(Student student);
	
	public Integer deleteStudent(Integer id);
	
	public List<Student> saveallstudents(List<Student> students );

}
