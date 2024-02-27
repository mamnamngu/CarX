package com.carx.controller.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carx.entity.schoolManagement.School;
import com.carx.entity.schoolManagement.Student;
import com.carx.service.schoolManagement.SchoolService;
import com.carx.service.schoolManagement.StudentService;
import com.carx.utilities.Constants;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> retrieveAllStudents(){
		return ResponseEntity.ok(studentService.findAll());
    }
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> retrieveStudent(@PathVariable long id) {
		Student student = studentService.findById(id);
		if(student != null) {
			return ResponseEntity.status(HttpStatus.OK).body(student);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("school/{schoolId}/student/name/{name}/status/{status}")
	public ResponseEntity<List<Student>> retrieveStudent(@PathVariable Integer schoolId, @PathVariable String name, @PathVariable Integer status) {
		//Validation
		if(name== null) name = "";
		else name = name.toLowerCase().trim();
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<Student> student = studentService.findByCombinedQuery(name, schoolId, status);
		return ResponseEntity.ok(student);
	}
	
	@PostMapping("school/{schoolId}/student")
	public ResponseEntity<Student> createStudent(@PathVariable Integer schoolId, @RequestBody Student student){
		try {
			//Check existence
			if(studentService.findById(student.getStudentId()) != null) 
				return ResponseEntity.badRequest().header("message", "Student with such ID already exists").build();

			School school = schoolService.findById(schoolId);
			if(school == null)
				return ResponseEntity.notFound().header("message", "No School found with such ID").build();
			
			//Set foreign keys
			student.setSchool(school);
			
			Student savedStudent = studentService.add(student);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new student").build();
		}
	}
	
	@PutMapping("school/{schoolId}/student")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer schoolId, @RequestBody Student student){
		//Check existence
		if(studentService.findById(student.getStudentId()) == null)
			return ResponseEntity.notFound().header("message", "No Student found for such ID").build();

		School school = schoolService.findById(schoolId);
		if(school == null)
			return ResponseEntity.notFound().header("message", "No School found with such ID").build();
		
		//Set foreign keys
		student.setSchool(school);
		
		Student updatedStudent = studentService.update(student);
		if(updatedStudent != null)
			return ResponseEntity.ok(updatedStudent);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id){
		try{
			if(studentService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Student found for such ID. Deletion failed").build();
			
			studentService.delete(id);
			return ResponseEntity.noContent().header("message", "student deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "student deletion failed").build();
		}
	}
}
