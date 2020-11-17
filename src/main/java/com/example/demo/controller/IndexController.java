package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Block;
import com.example.demo.model.Course;
import com.example.demo.model.Disciplina;
import com.example.demo.model.SchoolClass;
import com.example.demo.service.BlockService;
import com.example.demo.service.CourseService;
import com.example.demo.service.DisciplinaService;
import com.example.demo.service.SchoolClassService;


@Controller
public class IndexController {
	
	@Autowired
	private SchoolClassService schoolService;
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	//GET + LIST
	
	@GetMapping(value="/painelcurso")
	public String coursePainel(Model model) {
		List<Course> course = courseService.findAll();
		model.addAttribute("course", course);
		return "course/course-painel";
	}
	
	@GetMapping(value="/painelbloco")
	public String blockPainel(Model model) {
		List<Block> block = blockService.findAll();
		model.addAttribute("block", block);
		return "block/block-painel";
	}
	
	@GetMapping(value="/painelturma")
	public String schoolClassPainel(Model model) {
		List<SchoolClass> schoolClass = schoolService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		return "schoolclass/schoolclass-painel";
	}
	
	@GetMapping(value="/paineldisciplina")
	public String disciplinaPainel(Model model) {
		List<Disciplina> disciplina = disciplinaService.findAll();
		model.addAttribute("disciplina", disciplina);
		return "disciplina/disciplina-painel";
	}
	
	
	//GET
	
	@GetMapping(value="/")
	public String index() {
		return "home";
	}
	
	@GetMapping(value="/cadastrocurso")
	public String createCourseForm(Model model) {
		model.addAttribute("tipoForm", "Cadastro de");
		return "course/create-form";
	}
	
	@GetMapping(value="/cadastrobloco")
	public String createBlockForm(Model model) {
		List<SchoolClass> schoolClass = schoolService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("tipoForm", "Cadastro de");
		return "block/create-form";
	}
	
	@GetMapping(value="/cadastrodisciplina")
	public String createDisciplinaForm(Model model) {
		List<Block> block = blockService.findAll();
		model.addAttribute("block", block);
		model.addAttribute("tipoForm", "Cadastro de");
		return "disciplina/create-form";
	}
	
	@GetMapping(value="/cadastroturma")
	public String createSchoolClassForm(Model model) {
		List<Course> course = courseService.findAll();
		model.addAttribute("course", course);
		model.addAttribute("tipoForm", "Cadastro de");
		return "schoolclass/create-form";
	}
	
	
	//POST
	
	@PostMapping(value="createCourse")
	public String createCourse(Model model, Course course) {
		courseService.save(course);
		return "redirect:/painelcurso";
		
	}
	
	@PostMapping(value="createBlock")
	public String createBlock(Model model, Block block) {
		blockService.save(block);
		return "redirect:/painelbloco";
	}
	
	@PostMapping(value="createDisciplina")
	public String createDisciplina(Model model, Disciplina disciplina) {
		disciplinaService.save(disciplina);
		return "redirect:/paineldisciplina";
	}
	
	@PostMapping(value="createSchoolClass")
	public String createSchoolClass(Model model, SchoolClass schoolClass) {
		schoolService.save(schoolClass);
		return "redirect:/painelturma";
	}
	
	//DELETE
	
	@GetMapping(value="/delete/course/{id}")
	public String deleteCourse(@PathVariable("id") Integer id) {
		courseService.delete(id);
		return "redirect:/painelcurso";		
	}
	
	@GetMapping(value="/delete/block/{id}")
	public String deleteBlock(@PathVariable("id") Integer id) {
		blockService.delete(id);
		return "redirect:/painelbloco";
	}
	
	@GetMapping(value="/delete/disciplina/{id}")
	public String deleteDisciplina(@PathVariable("id") Integer id) {
		disciplinaService.delete(id);
		return "redirect:/paineldisciplina";
	}	
	
	@GetMapping(value="delete/schoolClass/{id}")
	public String deleteSchoolClass(@PathVariable("id") Integer id) {		
		schoolService.delete(id);
		return "redirect:/painelturma";
	}
	
	//UPDATE
	
	@GetMapping(value="/formedit/course/{id}")
	public String updateCourseForm(@PathVariable("id") Integer id, Model model) {
		Course course = courseService.findOne(id);
		model.addAttribute("course", course);
		model.addAttribute("tipoForm", "Atualizar");
		return "course/edit-form";
	}
	
	@PostMapping(value="/updateCourse")
	public String updateCourse(Model model, Course course) {
		courseService.save(course);
		return "redirect:/painelcurso";		
	}	
	
	@GetMapping(value="/formedit/block/{id}")
	public String updateBlockForm(@PathVariable("id") Integer id, Model model) {
		Block block = blockService.findOne(id);
		List<SchoolClass> schoolClass = schoolService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("block", block);
		model.addAttribute("tipoForm", "Atualizar");
		return "block/edit-form";
	}
	
	@PostMapping(value="/updateBlock")
	public String updateBlock(Model model, Block block) {
		blockService.save(block);
		return "redirect:/painelbloco";
	}
	
	@GetMapping(value="/formedit/disciplina/{id}")
	public String updateDisciplinaForm(@PathVariable("id") Integer id, Model model) {
		Disciplina disciplina = disciplinaService.findOne(id);
		List<Block> block = blockService.findAll();
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("block", block);
		model.addAttribute("tipoForm", "Atualizar");
		return "disciplina/edit-form";
	}
	
	@PostMapping(value="/updateDisciplina")
	public String updateDisciplina(Model model, Disciplina disciplina) {
		disciplinaService.save(disciplina);
		return "redirect:paineldisciplina";
	}
	
	@GetMapping(value="/formedit/schoolClass/{id}")
	public String updateSchoolClassForm(@PathVariable("id") Integer id, Model model) {
		SchoolClass schoolClass = schoolService.findOne(id);
		List<Course> course = courseService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("course", course);
		model.addAttribute("tipoForm", "Atualizar");
		return "schoolclass/edit-form";
		
	}
	
	@PostMapping(value="/updateSchoolClass")
	public String updateSchoolClass(Model model, SchoolClass schoolClass) {
		schoolService.save(schoolClass);
		return "redirect:/painelturma";
	}
	
}
