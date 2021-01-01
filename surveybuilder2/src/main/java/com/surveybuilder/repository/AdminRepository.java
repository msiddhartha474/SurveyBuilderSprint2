package com.surveybuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.enitity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	@Query("select a from Admin a where a.adminId = ?1")
	public Admin findAdminById(Long id);

}
