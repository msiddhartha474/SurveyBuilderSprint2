package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.enitity.Answer;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.AnswerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AnswerController{
	
	@Autowired
	private AnswerService as;
	

	@PostMapping("createAnswer")
	public Answer createAnswerController(@RequestBody Answer s) {
		return as.createAnswerService(s);
	}
	
	@GetMapping("viewAnswerById/{id}")
	public Answer viewAnswerByIdController(@PathVariable("id") Long id){
		Answer a = as.viewAnswerByIdService(id);
		Answer a1 = new Answer();
		a1.setAid(a.getAid());
		a1.setAns(a.getAns());
		return a1;
	}
	
	@PutMapping("updateAnswer/{id}")
	public Answer updateAnswerController(@RequestBody Answer s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return as.updateAnswerService(s, id);
	}
	
	@DeleteMapping("deleteAnswerById/{id}")
	public String deleteAnswerByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(as.deleteAnswerByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	@GetMapping("listAllAnswer")
	public List<Answer> listAllAnswerController(){
		List<Answer> list = new ArrayList<Answer>();
		
		for(Answer a: as.listAllAnswerService()) {
			Answer a1 = new Answer();
			a1.setAid(a.getAid());
			a1.setAns(a.getAns());
			list.add(a1);
		}
		return list;
	}
	
	
}