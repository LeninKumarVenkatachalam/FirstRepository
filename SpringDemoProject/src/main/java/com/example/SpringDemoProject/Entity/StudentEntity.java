package com.example.SpringDemoProject.Entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Component
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid")
	private int id;
	
	@Column(name = "sname")
	private String name;

	@Column(name = "sstandard")
	private int standard;

	@Column(name = "ssection")
	private char section;

	@Column(name = "sfees")
	private float fees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public char getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public StudentEntity(int id, String name, int standard, char section, float fees) {
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.section = section;
		this.fees = fees;
	}

	public StudentEntity() {
	
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", standard=" + standard + ", section=" + section
				+ ", fees=" + fees + "]";
	}
	
}
