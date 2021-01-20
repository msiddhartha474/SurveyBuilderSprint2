package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.enitity.Question;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.repository.QuestionRepository;



@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionRepository qr;
	
	@Override
	public Question createQuestionService(Question s) {
		Question a = qr.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not save Question :: ");
		}
		
		return a ;
	}

	@Override
	public Question viewQuestionByIdService(long id) {
		Question a = qr.findQuestionById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Question not found for this id :: "+ id);
		}
		return a;
	}

	@Override
	public Question updateQuestionService(Question s, long id) throws ResourceNotFoundException {
		Question a = qr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + id));
		
		s.setQid(a.getQid());
		
		final Question updatedA= qr.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteQuestionByIdService(long id) throws ResourceNotFoundException {
		
		Question a = qr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + id));
		
		qr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Question> listAllQuestionService() {
		return qr.findAll();
	}

	@Override
	public List<Question> getQuestionBySurveyIdService(long id) {
		return qr.getQuestionBySurveyId(id);
	}

}
