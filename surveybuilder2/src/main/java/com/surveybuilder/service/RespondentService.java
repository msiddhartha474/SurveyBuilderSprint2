package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.enitity.Respondent;
import com.surveybuilder.exception.ResourceNotFoundException;

public interface RespondentService {
	public Respondent createRespondentService(Respondent s);
	public Respondent viewRespondentByIdService(long id);
	public Respondent updateRespondentService(Respondent s, long id) throws ResourceNotFoundException;
	public boolean deleteRespondentByIdService(long id) throws ResourceNotFoundException;
	public List<Respondent> listAllRespondentService();
	public Respondent authRespondent(String emailId, String pass);
}
