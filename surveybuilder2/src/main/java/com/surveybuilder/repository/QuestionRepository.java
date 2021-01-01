package com.surveybuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.enitity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	@Query("select q from Question q where q.Qid = ?1")
	public Question findQuestionById(Long id);

}
