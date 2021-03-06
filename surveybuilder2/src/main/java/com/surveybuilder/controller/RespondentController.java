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

import com.surveybuilder.enitity.Respondent;
import com.surveybuilder.enitity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.RespondentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RespondentController{
	
	@Autowired
	private RespondentService rs;
	

	@GetMapping("authRespondent/{emailId}/{pass}")
	public Respondent authRespondentController(@PathVariable("emailId") String emailId, @PathVariable("pass") String pass){
		Respondent s = rs.authRespondent(emailId, pass);
		
		if( s != null) {
			Respondent s1 = new Respondent();
			s1.setEmailId(s.getEmailId());
			s1.setName(s.getName());
			s1.setPassword(s.getPassword());
			s1.setRespondentId(s.getRespondentId());
			return s1;
		}else
			return null;
	}
	
	@PostMapping("createRespondent")
	public Respondent createRespondentController(@RequestBody Respondent s) {
		return rs.createRespondentService(s);
	}
	
	@GetMapping("viewRespondentById/{id}")
	public Respondent viewRespondentByIdController(@PathVariable("id") Long id){
		
		Respondent r = rs.viewRespondentByIdService(id);
		Respondent r1 = new Respondent();
		r1.setEmailId(r.getEmailId());
		r1.setName(r.getName());
		r1.setPassword(r.getPassword());
		r1.setRespondentId(r.getRespondentId());
		return r1;
	}
	
	@PutMapping("updateRespondent/{id}")
	public Respondent updateRespondentController(@RequestBody Respondent s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return rs.updateRespondentService(s, id);
	}
	
	@DeleteMapping("deleteRespondentById/{id}")
	public String deleteRespondentByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(rs.deleteRespondentByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	@GetMapping("listAllRespondent")
	public List<Respondent> listAllRespondentController(){
		
		List<Respondent> lst = new ArrayList<Respondent>();
		
		for(Respondent a : rs.listAllRespondentService()) {
			Respondent a1 = new Respondent();
			a1.setRespondentId(a.getRespondentId());
			a1.setEmailId(a.getEmailId());
			a1.setName(a.getName());
			a1.setPassword(a.getPassword());
			lst.add(a1);
		}
		
		return lst;
	}
	
	
}