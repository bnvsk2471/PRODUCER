package com.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Entity.Student;
import com.Student.Service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
@Api(value="This is used for student")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/showall")
	@ApiOperation("This is used to show all student data")//This annotation is used for swagger to display details about api
	public ResponseEntity<List<Student>> getAll() {

		List<Student> students = service.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@ApiOperation("This is used to save student")
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student students = service.saveStudent(student);

		return new ResponseEntity<Student>(students, HttpStatus.CREATED);

	}
	
	@ApiOperation("This is used to save all student")
	@PostMapping("/saveall")
	public ResponseEntity<List<Student>> saveStudent(@RequestBody List<Student> student) {
		List<Student> students = service.saveallstudents(student);
		return new ResponseEntity<List<Student>>(students, HttpStatus.CREATED);
	}
	
	@ApiOperation("This is used to save all student")
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(@RequestBody Integer id) {
		service.deleteStudent(id);
		return new ResponseEntity<String>("Student with "+id+" deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<Student> getStudent(
			@PathVariable Integer id
			){
		 Student student = service.getStudent(id);
		 return new ResponseEntity<Student>(student,HttpStatus.OK);
	}

}
