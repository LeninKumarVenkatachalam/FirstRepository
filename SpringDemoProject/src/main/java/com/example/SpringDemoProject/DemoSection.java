package com.example.SpringDemoProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDemoProject.Entity.StudentEntity;
import com.fasterxml.jackson.core.format.InputAccessor.Std;

@RestController
@RequestMapping("/demo")
public class DemoSection {

	@GetMapping("/data")
	public String getData() {
		return "demo data";
	}
	
	@Autowired
	private StudentEntity std;
	
}
