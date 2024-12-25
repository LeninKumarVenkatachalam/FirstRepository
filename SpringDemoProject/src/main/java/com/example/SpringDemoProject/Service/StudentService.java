package com.example.SpringDemoProject.Service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringDemoProject.Entity.StudentEntity;

@Component
public interface StudentService {

	public boolean updateValue(int id, StudentEntity std);

	public StudentEntity getSingleData(int id);

	public List<StudentEntity> getAllData(String name);

	public List<StudentEntity> getAllFeesData(int fees);

	public List<StudentEntity> getAllByStan(int standard);

}
