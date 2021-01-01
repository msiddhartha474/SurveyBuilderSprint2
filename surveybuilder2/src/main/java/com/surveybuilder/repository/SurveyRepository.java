package com.surveybuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.enitity.Survey;


@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long>{
	@Query("select s from Survey s where s.sid = ?1")
	public Survey findSurveyById(Long id);
}
