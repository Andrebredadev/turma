package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Block;
import com.example.demo.repository.BlockRepository;

@Service
public class BlockService {
	
	@Autowired
	private BlockRepository blockRepository;
	
	public List<Block> findAll(){
		return blockRepository.findAll();
	}
	
	public Block findOne(Integer id) {
		return blockRepository.findById(id).get();
	}
	
	@Transactional
	public Block save(Block block) {
		return blockRepository.save(block);
	}
	
	@Transactional
	public void delete(Integer id) {
		blockRepository.deleteById(id);
	}
	
	public BlockService(BlockRepository blockRepository) {
		this.blockRepository = blockRepository;
	}

}
