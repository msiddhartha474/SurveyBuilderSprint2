package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.enitity.Question;
import com.surveybuilder.exception.ResourceNotFoundException;

public interface QuestionService {
	public Question createQuestionService(Question s);
	public Question viewQuestionByIdService(long id);
	public Question updateQuestionService(Question s, long id) throws ResourceNotFoundException ;
	public boolean deleteQuestionByIdService(long id) throws ResourceNotFoundException ;
	public List<Question> listAllQuestionService();
	
}
