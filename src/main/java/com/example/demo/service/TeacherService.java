package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> findAll(){
		return teacherRepository.findAll();
	}
	
	public Teacher findOne(Integer id) {
		return teacherRepository.findById(id).get();
	}
	
	@Transactional
	public Teacher save(Teacher teacher){
		return teacherRepository.save(teacher);		
	}
	
	@Transactional
	public void delete(Integer id) {
		teacherRepository.deleteById(id);
	}
	
	public TeacherService(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

}
