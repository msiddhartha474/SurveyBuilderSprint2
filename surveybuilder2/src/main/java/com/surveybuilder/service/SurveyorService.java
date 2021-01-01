package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.enitity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;

public interface SurveyorService {
	public Surveyor createSurveyorService(Surveyor s);
	public Surveyor viewSurveyorByIdService(long id);
	public Surveyor updateSurveyorService(Surveyor s, long id) throws ResourceNotFoundException;
	public boolean deleteSurveyorByIdService(long id) throws ResourceNotFoundException;
	public List<Surveyor> listAllSurveyorService();
	
}
