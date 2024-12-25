package com.example.SpringDemoProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.SpringDemoProject.Entity.StudentEntity;
import com.example.SpringDemoProject.Repository.StudentRepository;
import com.example.SpringDemoProject.Service.StudentService;

import jakarta.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringDemoProjectApplicationTests {

	@Mock
	private StudentRepository stdRepo;
	
	@Autowired
	private StudentService stdService;
	
	@Test
	void testData() {
		StudentEntity st=new StudentEntity();
		st.setId(1);
		st.setFees(500000);
		st.setName("happy");
		st.setSection('Z');
		st.setStandard(10);
		
		when(stdRepo.findById(1)).thenReturn(Optional.of(st));
		assertEquals(true, stdService.updateValue(1, st));
		
		assertNotNull(stdRepo.findById(1));
	}
	

}
