package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue
	@Column(name="teacher_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="teacher_name")
	private String name;
	
	@OneToMany(mappedBy="teacher", cascade=CascadeType.ALL)
	private List<SchoolClass> schoolClasses = new ArrayList<>();

	public List<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}

	public void addSchoolClass(SchoolClass schoolClass) {
		this.schoolClasses.add(schoolClass);
	}
	
	public void removeSchoolClass(SchoolClass schoolClass) {
		this.schoolClasses.remove(schoolClass);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
