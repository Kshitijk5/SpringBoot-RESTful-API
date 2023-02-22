package com.springdemopractice.Springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemopractice.Springdemo.dao.TeacherDAO;
import com.springdemopractice.Springdemo.entity.Teacher;
import com.springdemopractice.Springdemo.globalException.Status;
//import com.springdemopractice.Springdemo.globalException.TeacherException;
import com.springdemopractice.Springdemo.globalException.TeacherNoSuchIdException;

@RestController
@RequestMapping("/api")
public class Main {
	 
	@Autowired
	private TeacherDAO dao;
	
	//add Teacher	
	@PostMapping("/teacher")
	public Status add(@RequestBody Teacher t) throws TeacherNoSuchIdException {
		return dao.addTeacher(t);
	}
	
	//list all teacher	
	@GetMapping("/teacher")
	public List<Teacher> listAllTeacher() {
		return dao.Listall();
	}
	
	//find by id
	@GetMapping("/teacher/{id}")
	
	public Teacher findbyid(@PathVariable int id) throws TeacherNoSuchIdException {
		return dao.byId(id);
	}
	
	
	//Update Teacher	
	@PutMapping("/teacher")
	public Status update(@RequestBody Teacher t) throws TeacherNoSuchIdException {
		return dao.update(t);
	}
	
	//Delete Teacher by ID	
	@DeleteMapping("/teacher/{id}")
	
	public Status delete(@PathVariable int id) throws TeacherNoSuchIdException {
		return dao.deleteTeacher(id);
		
	}

}
