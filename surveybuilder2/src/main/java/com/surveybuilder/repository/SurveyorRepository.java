package com.surveybuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.enitity.Surveyor;

@Repository
public interface SurveyorRepository extends JpaRepository<Surveyor, Long>{
	
	@Query("select s from Surveyor s where s.surveyorId = ?1")
	public Surveyor findSurveyorById(Long id);

	@Query("select a from Surveyor a where (a.emailId = ?1 and a.password = ?2)")
	public Surveyor authSurveyor(String emailId, String pass);
}
