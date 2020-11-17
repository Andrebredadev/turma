package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Disciplina;
import com.example.demo.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public List<Disciplina> findAll(){
		return disciplinaRepository.findAll();
	}
	
	public Disciplina findOne(Integer id) {
		return disciplinaRepository.findById(id).get();
	}
	
	@Transactional
	public Disciplina save(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	@Transactional
	public void delete(Integer id) {
		disciplinaRepository.deleteById(id);
	}
	
	public DisciplinaService(DisciplinaRepository disciplinaRepository) {
		this.disciplinaRepository = disciplinaRepository;
	}

}
