package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.enitity.Answer;
import com.surveybuilder.exception.ResourceNotFoundException;

public interface AnswerService {
	public Answer createAnswerService(Answer s);
	public Answer viewAnswerByIdService(long id);
	public Answer updateAnswerService(Answer s, long id) throws ResourceNotFoundException;
	public boolean deleteAnswerByIdService(long id) throws ResourceNotFoundException;
	public List<Answer> listAllAnswerService();
}
