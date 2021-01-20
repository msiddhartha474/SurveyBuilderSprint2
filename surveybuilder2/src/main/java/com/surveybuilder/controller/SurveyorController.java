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

import com.surveybuilder.enitity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.SurveyorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SurveyorController{
	
	@Autowired
	private SurveyorService ss;
	

	@GetMapping("authSurveyor/{emailId}/{pass}")
	public Surveyor authSurveyorController(@PathVariable("emailId") String emailId, @PathVariable("pass") String pass){
		Surveyor s = ss.authSurveyor(emailId, pass);
		
		if( s != null) {
			Surveyor s1 = new Surveyor();
			s1.setEmailId(s.getEmailId());
			s1.setName(s.getName());
			s1.setPassword(s.getPassword());
			s1.setSurveyorId(s.getSurveyorId());
			return s1;
		}else
			return null;
	}
	
	@PostMapping("createSurveyor")
	public Surveyor createSurveyorController(@RequestBody Surveyor s) {
		return ss.createSurveyorService(s);
	}
	
	@GetMapping("viewSurveyorById/{id}")
	public Surveyor viewSurveyorByIdController(@PathVariable("id") long id){
		Surveyor s = ss.viewSurveyorByIdService(id);
		Surveyor s1 = new Surveyor();
		s1.setEmailId(s.getEmailId());
		s1.setName(s.getName());
		s1.setPassword(s.getPassword());
		s1.setSurveyorId(s.getSurveyorId());
		return s1;
	}
	
	@PutMapping("updateSurveyor/{id}")
	public Surveyor updateSurveyorController(@RequestBody Surveyor s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return ss.updateSurveyorService(s, id);
	}
	
	@DeleteMapping("deleteSurveyorById/{id}")
	public String deleteSurveyorByIdController(@PathVariable("id") long id) throws ResourceNotFoundException{
		if(ss.deleteSurveyorByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";	
	}
	
	@GetMapping("listAllSurveyor")
	public List<Surveyor> listAllSurveyorController(){
		List<Surveyor> lst = new ArrayList<Surveyor>();
		
		for(Surveyor a : ss.listAllSurveyorService()) {
			Surveyor a1 = new Surveyor();
			a1.setSurveyorId(a.getSurveyorId());
			a1.setEmailId(a.getEmailId());
			a1.setName(a.getName());
			a1.setPassword(a.getPassword());
			lst.add(a1);
		}
		
		return lst;
	}
	
	
}