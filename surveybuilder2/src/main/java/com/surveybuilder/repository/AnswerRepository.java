package com.surveybuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.enitity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{
	@Query("select a from Answer a where a.aid = ?1")
	public Answer findAnswerById(Long id);

}
