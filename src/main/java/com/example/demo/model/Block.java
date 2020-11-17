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
public class Block {
	
	@Id
	@GeneratedValue
	@Column(name="block_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name="block_name")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	private SchoolClass schoolClass;	

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	
	@OneToMany(mappedBy="block", cascade=CascadeType.ALL)
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	public List<Disciplina> getDisciplina(){
		return disciplinas;
	}
	

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public void removeBlock(Disciplina disciplina) {
		this.disciplinas.remove(disciplina);
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
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
