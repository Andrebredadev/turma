package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.SchoolClass;
import com.example.demo.repository.SchoolClassRepository;

@Service
public class SchoolClassService {
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	public List<SchoolClass> findAll(){
		return schoolClassRepository.findAll();
	}
	
	public SchoolClass findOne(Integer id) {
		return schoolClassRepository.findById(id).get();
	}
	
	@Transactional
	public SchoolClass save(SchoolClass schoolClass){
		return schoolClassRepository.save(schoolClass);		
	}
	
	@Transactional
	public void delete(Integer id) {
		schoolClassRepository.deleteById(id);
	}
	
	public SchoolClassService(SchoolClassRepository schoolClassRepository) {
		this.schoolClassRepository = schoolClassRepository;
	}

}
