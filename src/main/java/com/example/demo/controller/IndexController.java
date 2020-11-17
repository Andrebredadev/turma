package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.SchoolClass;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.service.SchoolClassService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;

@Controller
public class IndexController {
	
	@Autowired
	private StudentService studentService;	
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SchoolClassService schoolService;
	
	//GET + LIST
	
	@GetMapping(value="/painelaluno")
	public String studentPainel(Model model) {
		List<Student> student = studentService.findAll();
		model.addAttribute("student", student);
		return "student/student-painel";
	}
	
	@GetMapping(value="/painelprofessor")
	public String teacherPainel(Model model) {
		List<Teacher> teacher = teacherService.findAll();
		model.addAttribute("teacher", teacher);
		return "teacher/teacher-painel";
	}
	
	@GetMapping(value="/painelturma")
	public String schoolClassPainel(Model model) {
		List<SchoolClass> schoolClass = schoolService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		return "schoolclass/schoolclass-painel";
	}
	
	
	//GET
	
	@GetMapping(value="/")
	public String index() {
		return "home";
	}
	
	@GetMapping(value="/cadastroaluno")
	public String createStudentForm(Model model) {
		List<SchoolClass> schoolClass = schoolService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("tipoForm", "Cadastro de");
		return "student/create-form";
	}
	
	@GetMapping(value="/cadastroprofessor")
	public String createTeacherForm(Model model) {
		model.addAttribute("tipoForm", "Cadastro de");
		return "teacher/create-form";
	}
	
	@GetMapping(value="/cadastroturma")
	public String createSchoolClassForm(Model model) {
		List<Teacher> teacher = teacherService.findAll();
		model.addAttribute("teacher", teacher);
		model.addAttribute("tipoForm", "Cadastro de");
		return "schoolclass/create-form";
	}
	
	
	//POST
	
	@PostMapping(value="createStudent")
	public String createStudent(Model model, Student student) {
		studentService.save(student);
		return "redirect:/painelaluno";
		
	}
	
	@PostMapping(value="createTeacher")
	public String createTeacher(Model model, Teacher teacher) {
		teacherService.save(teacher);
		return "redirect:/painelprofessor";
	}
	
	@PostMapping(value="createSchoolClass")
	public String createSchoolClass(Model model, SchoolClass schoolClass) {
		schoolService.save(schoolClass);
		return "redirect:/painelturma";
	}
	
	//DELETE
	//@dec DELETE ONE STUDENT
	
	@GetMapping(value="/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		studentService.delete(id);
		return "redirect:/painelaluno";		
	}
	
	//DELETE
	//@desc DELETE ONE TEACHER
	
	@GetMapping(value="/delete/teacher/{id}")
	public String deleteTeacher(@PathVariable("id") Integer id) {
		teacherService.delete(id);
		return "redirect:/painelprofessor";
	}
	
	//DELETE
	//@desc DELETE ONE SCHOOL CLASS
	
	@GetMapping(value="delete/schoolClass/{id}")
	public String deleteSchoolClass(@PathVariable("id") Integer id) {		
		schoolService.delete(id);
		return "redirect:/painelturma";
	}
	
	//UPDATE STUDENT
	//@desc UPDATE ONE STUDENT 
	
	@GetMapping(value="/formedit/student/{id}")
	public String updateStudentForm(@PathVariable("id") Integer id, Model model) {
		Student student = studentService.findOne(id);
		List<SchoolClass> schoolClass = schoolService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("student", student);
		model.addAttribute("tipoForm", "Atualizar");
		return "student/edit-form";
	}
	
	@PostMapping(value="/updateStudent")
	public String updateStudent(Model model, Student student) {
		studentService.save(student);
		return "redirect:/painelaluno";		
	}
	
	//UPDATE TEACHER
	//@desc UPDATE ONE TEACHER
	
	@GetMapping(value="/formedit/teacher/{id}")
	public String updateTeacherForm(@PathVariable("id") Integer id, Model model) {
		Teacher teacher = teacherService.findOne(id);
		model.addAttribute("teacher", teacher);
		model.addAttribute("tipoForm", "Atualizar");
		return "teacher/edit-form";
	}
	
	@PostMapping(value="/updateTeacher")
	public String updateTeacher(Model model, Teacher teacher) {
		teacherService.save(teacher);
		return "redirect:/painelprofessor";
	}
	
	//UPDATE SCHOOL CLASS
	//@desc UPDATE ONE SCHOOL CLASS
	@GetMapping(value="/formedit/schoolClass/{id}")
	public String updateSchoolClassForm(@PathVariable("id") Integer id, Model model) {
		SchoolClass schoolClass = schoolService.findOne(id);
		List<Teacher> teacher = teacherService.findAll();
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("teacher", teacher);
		model.addAttribute("tipoForm", "Atualizar");
		return "schoolclass/edit-form";
		
	}
	
	@PostMapping(value="/updateSchoolClass")
	public String updateSchoolClass(Model model, SchoolClass schoolClass) {
		schoolService.save(schoolClass);
		return "redirect:/painelturma";
	}
	
}
