package com.surveybuilder.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.surveybuilder.SurveyBuilderApplication;
import com.surveybuilder.enitity.Surveyor;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = Surveyor.class)
class SurveyorTest {

	private Surveyor surveyor = new Surveyor();
	   
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSurveyorId() {
		long mockId = 101;
		surveyor.setSurveyorId(mockId);
		long id = surveyor.getSurveyorId();
		
		assertThat(id).isEqualTo(mockId);
	    
	}

	@Test
	void testSetSurveyorId() {
		long mockId = 101;
		surveyor.setSurveyorId(mockId);
		long id = surveyor.getSurveyorId();
		
		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testGetName() {
		String mockName = "Sid";
		surveyor.setName(mockName);
		String name = surveyor.getName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetName() {
		String mockName = "Sid";
		surveyor.setName(mockName);
		String name = surveyor.getName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testGetEmailId() {
		String mockEmail = "Sid@gmail.com";
		surveyor.setEmailId(mockEmail);
		String email = surveyor.getEmailId();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testSetEmailId() {
		String mockEmail = "Sid@gmail.com";
		surveyor.setEmailId(mockEmail);
		String email = surveyor.getEmailId();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testGetPassword() {
		String mockPass = "Sid123";
		surveyor.setPassword(mockPass);
		String pass = surveyor.getPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

	@Test
	void testSetPassword() {
		String mockPass = "Sid123";
		surveyor.setPassword(mockPass);
		String pass = surveyor.getPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

}
