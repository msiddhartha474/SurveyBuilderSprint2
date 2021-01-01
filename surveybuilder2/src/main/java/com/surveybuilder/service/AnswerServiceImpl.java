package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.enitity.Answer;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.repository.AnswerRepository;



@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerRepository ar;
	
	@Override
	public Answer createAnswerService(Answer s) {
		Answer a = ar.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not save answer :: ");
		}
		
		return a ;
	}

	@Override
	public Answer viewAnswerByIdService(long id) {
		Answer a = ar.findAnswerById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Answer not found for this id :: "+ id);
		}
		return a;
	}

	@Override
	public Answer updateAnswerService(Answer s, long id) throws ResourceNotFoundException {
		Answer a = ar.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer not found for this id :: " + id));
		
		s.setAid(a.getAid());
		
		final Answer updatedA= ar.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteAnswerByIdService(long id) throws ResourceNotFoundException {
		
		Answer a = ar.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer not found for this id :: " + id));
		
		ar.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Answer> listAllAnswerService() {
		return ar.findAll();
	}

}
