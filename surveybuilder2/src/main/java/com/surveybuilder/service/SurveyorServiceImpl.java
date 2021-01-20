package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.enitity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.repository.SurveyorRepository;



@Service
public class SurveyorServiceImpl implements SurveyorService{
	@Autowired
	private SurveyorRepository rr;
	
	@Override
	public Surveyor createSurveyorService(Surveyor s) {
		Surveyor a = rr.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not create surveyor profile :: ");
		}
		
		return a ;
	}

	@Override
	public Surveyor viewSurveyorByIdService(long id) {
		Surveyor a = rr.findSurveyorById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Surveyor not found for this id :: "+ id);
		}
		return a;
	}

	@Override
	public Surveyor updateSurveyorService(Surveyor s, long id) throws ResourceNotFoundException {
		Surveyor a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		s.setSurveyorId(a.getSurveyorId());
		
		final Surveyor updatedA= rr.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteSurveyorByIdService(long id) throws ResourceNotFoundException {
		
		Surveyor a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		rr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Surveyor> listAllSurveyorService() {
		return rr.findAll();
	}

	@Override
	public Surveyor authSurveyor(String emailId, String pass) {
		// TODO Auto-generated method stub
		return rr.authSurveyor(emailId, pass);
	}

}
