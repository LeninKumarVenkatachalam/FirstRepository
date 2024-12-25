package com.example.SpringDemoProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringDemoProject.Entity.StudentEntity;
import com.example.SpringDemoProject.Repository.StudentRepository;


@Service
public class StudentServiceIMPL implements StudentService{

	@Autowired(required = true)
	private StudentRepository stdRepo;
	
	@Override
	public boolean updateValue(int id, StudentEntity std) {
		Optional<StudentEntity> st=stdRepo.findById(id);
		if(!st.isEmpty()) {
			stdRepo.save(std);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public StudentEntity getSingleData(int id) {
		Optional<StudentEntity> st=stdRepo.findById(id);
		if(!st.isEmpty()) {
			return st.get();
		}
		return null;
	}

	@Override
	public List<StudentEntity> getAllData(String name) {
		List<StudentEntity> list=stdRepo.findAllByName(name);
		return list;
	}

	@Override
	public List<StudentEntity> getAllFeesData(int fees) {
		List<StudentEntity> allList=stdRepo.findAll();
		  
		return allList.stream().filter(t -> t.getFees() > fees).toList();
	}

	@Override
	public List<StudentEntity> getAllByStan(int standard) {
		List<StudentEntity> list=stdRepo.findAllDataByStan(standard);
		System.out.println(list);
		return list;
	}

}
