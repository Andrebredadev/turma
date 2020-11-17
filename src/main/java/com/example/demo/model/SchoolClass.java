package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SchoolClass {
	
	@Id
	@GeneratedValue
	@Column(name="class_id", unique=true, nullable=false)
	private Integer classID;
	
	@Column(name="class_name")
	private String className;	
	
	@OneToMany(mappedBy="schoolClass", cascade=CascadeType.ALL)
	private List<Block> blocks = new ArrayList<>();
	
	public List<Block> getBlocks(){
		return blocks;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private Course course;	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void addBlock(Block block) {
		this.blocks.add(block);
	}
	
	public void removeBlock(Block block) {
		this.blocks.remove(block);
	}

	public Integer getClassID() {
		return classID;
	}

	public void setClassID(Integer classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}	

}
