package com.surveybuilder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.enitity.Survey;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.repository.SurveyRepository;



@Service
public class SurveyServiceImpl implements SurveyService{
	@Autowired
	private SurveyRepository rr;
	
	@Override
	public Survey createSurveyService(Survey s) {
		Survey a = rr.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not save Survey :: ");
		}
		
		return a ;
	}

	@Override
	public Survey viewSurveyByIdService(long id) {
		Survey a = rr.findSurveyById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Survey not found for this id :: "+ id);
		}
		return a;
	}

	@Override
	public Survey updateSurveyService(Survey s, long id) throws ResourceNotFoundException {
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + id));
		
		s.setSid(a.getSid());
		
		final Survey updatedA= rr.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteSurveyByIdService(long id) throws ResourceNotFoundException {
		
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + id));
		
		rr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Survey> listAllSurveyService() {
		return rr.findAll();
	}

}
