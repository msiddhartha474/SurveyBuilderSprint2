package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.enitity.Question;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.QuestionService;

@RestController
public class QuestionController{
	
	@Autowired
	private QuestionService ss;
	

	@PostMapping("createQuestion")
	public Question createQuestionController(@RequestBody Question s) {
		return ss.createQuestionService(s);
	}
	
	@GetMapping("viewQuestionById/{id}")
	public Question viewQuestionByIdController(@PathVariable("id") Long id){
		Question q = ss.viewQuestionByIdService(id);
		Question q1 = new Question();
		
		q1.setQid(q.getQid());
		q1.setQuestion(q.getQuestion());
		q1.setOption1(q.getOption1());
		q1.setOption2(q.getOption2());
		q1.setOption3(q.getOption3());
		q1.setOption4(q.getOption4());
		
		return q1;
	}
	
	@PutMapping("updateQuestion/{id}")
	public Question updateQuestionController(@RequestBody Question s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return ss.updateQuestionService(s, id);
	}
	
	@DeleteMapping("deleteQuestionById/{id}")
	public String deleteQuestionByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(ss.deleteQuestionByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	@GetMapping("listAllQuestion")
	public List<Question> listAllQuestionController(){

		List<Question> lst = new ArrayList<Question>();
		
		for(Question q: ss.listAllQuestionService()) {
			Question q1 = new Question();
			
			q1.setQid(q.getQid());
			q1.setQuestion(q.getQuestion());
			q1.setOption1(q.getOption1());
			q1.setOption2(q.getOption2());
			q1.setOption3(q.getOption3());
			q1.setOption4(q.getOption4());
			
			lst.add(q1);
		}
		
		return lst;
	}
	
	
}