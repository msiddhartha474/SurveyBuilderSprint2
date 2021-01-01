package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.enitity.Survey;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.SurveyService;

@RestController
public class SurveyController{
	
	@Autowired
	private SurveyService ss;
	

	@PostMapping("createSurvey")
	public Survey createSurveyController(@RequestBody Survey survey) {
		return ss.createSurveyService(survey);
	}
	
	@GetMapping("viewSurveyById/{id}")
	public Survey viewSurveyByIdController(@PathVariable("id") Long id){
		
		Survey s = ss.viewSurveyByIdService(id);
		Survey s1 = new Survey();
		
		s1.setSid(s.getSid());
		s1.setDueDate(s.getDueDate());
		s1.setFeedback(s.getFeedback());
		s1.setStatus(s.getStatus());
		s1.setTitle(s.getTitle());
		
		return s1;
	}
	
	@PutMapping("updateSurvey/{id}")
	public Survey updateSurveyController(@RequestBody Survey survey, @PathVariable("id") long id) throws ResourceNotFoundException {
		return ss.updateSurveyService(survey, id);
	}
	
	@DeleteMapping("deleteSurveyById/{id}")
	public String deleteSurveyByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(ss.deleteSurveyByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	@GetMapping("listAllSurvey")
	public List<Survey> listAllSurveyController(){
		List<Survey> lst = new ArrayList<Survey>();
		
		for(Survey s : ss.listAllSurveyService()) {
			Survey s1 = new Survey();
			
			s1.setSid(s.getSid());
			s1.setDueDate(s.getDueDate());
			s1.setFeedback(s.getFeedback());
			s1.setStatus(s.getStatus());
			s1.setTitle(s.getTitle());
			
			lst.add(s1);
		}
		
		return lst;
	}
	
	
}