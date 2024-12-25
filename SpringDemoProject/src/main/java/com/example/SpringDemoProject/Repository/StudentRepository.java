package com.example.SpringDemoProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.SpringDemoProject.Entity.StudentEntity;

@Repository
@Component
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

	List<StudentEntity> findAllByName(String name);

	String query="select * from student_entity where sstandard =:sstandard";
	
	@Query(nativeQuery = true,value = query)
	List<StudentEntity> findAllDataByStan(@Param(value = "sstandard")  int standard);
}
