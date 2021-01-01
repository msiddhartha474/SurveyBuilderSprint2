package com.surveybuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.enitity.Respondent;

@Repository
public interface RespondentRepository extends JpaRepository<Respondent, Long>{
	@Query("select r from Respondent r where r.respondentId = ?1")
	public Respondent findRespondentById(Long id);


}
