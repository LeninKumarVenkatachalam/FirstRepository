package com.example.SpringDemoProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDemoProject.Entity.StudentEntity;
import com.example.SpringDemoProject.Repository.StudentRepository;
import com.example.SpringDemoProject.Service.StudentService;

@RestController
@RequestMapping("/main")
public class StudentController {

	@Autowired
	private StudentRepository stdRepo;
	
	@Autowired(required = true)
	private StudentService stdService;
	
	@PostMapping("/post")
	public ResponseEntity<StudentEntity> postData(@RequestBody StudentEntity std){
		if(std==null) {
			return new ResponseEntity<StudentEntity>(HttpStatus.BAD_REQUEST);	
		}
		else {
			stdRepo.save(std);
		}
		return new ResponseEntity<StudentEntity>(std,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteData(@RequestParam(name = "sid",defaultValue = "default") int id){
		stdRepo.deleteById(id);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StudentEntity> updateData(@RequestBody StudentEntity std){
		if(stdService.updateValue(std.getId(),std)) {
			return new ResponseEntity<StudentEntity>(std,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentEntity>(HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<StudentEntity> readData(@PathVariable(name = "id") int id){
		if(stdService.getSingleData(id) == null) {
			return new ResponseEntity<StudentEntity>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<StudentEntity>(stdService.getSingleData(id),HttpStatus.OK);
	}

	
	@GetMapping("/getAll/{name}")
	public ResponseEntity<List<StudentEntity>> readAllData(@PathVariable(name = "name") String name){
		 
		return new ResponseEntity<List<StudentEntity>>(stdService.getAllData(name),HttpStatus.OK);
	}
	
	@GetMapping("/getByFees/{fees}")
	public ResponseEntity<List<StudentEntity>> readAllFeesData(@PathVariable(name = "fees") int fees){
		
		return new ResponseEntity<List<StudentEntity>>(stdService.getAllFeesData(fees),HttpStatus.OK);
	}
	
	@GetMapping("/getDataByStandard/{standard}")
	public ResponseEntity<List<StudentEntity>> getDataByStandard(@PathVariable(name = "standard") int standard){
		
		return new ResponseEntity<List<StudentEntity>>(stdService.getAllByStan(standard),HttpStatus.OK);
	}
}
