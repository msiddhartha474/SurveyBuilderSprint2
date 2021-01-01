package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.enitity.Respondent;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.repository.RespondentRepository;



@Service
public class RespondentServiceImpl implements RespondentService{
	@Autowired
	private RespondentRepository rr;
	
	@Override
	public Respondent createRespondentService(Respondent s) {
		Respondent a = rr.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not create Respondent :: ");
		}
		
		return a ;
	}

	@Override
	public Respondent viewRespondentByIdService(long id) {
		Respondent a = rr.findRespondentById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Respondent not found for this id :: "+ id);
		}
		return a;
	}

	@Override
	public Respondent updateRespondentService(Respondent s, long id) throws ResourceNotFoundException {
		Respondent a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respondent not found for this id :: " + id));
		
		s.setRespondentId(a.getRespondentId());
		
		final Respondent updatedA= rr.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteRespondentByIdService(long id) throws ResourceNotFoundException {
		
		Respondent a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respondent not found for this id :: " + id));
		
		rr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Respondent> listAllRespondentService() {
		return rr.findAll();
	}

}
