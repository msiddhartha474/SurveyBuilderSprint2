package com.surveybuilder.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.surveybuilder.enitity.Question;
import com.surveybuilder.enitity.Respondent;
import com.surveybuilder.enitity.Survey;
import com.surveybuilder.enitity.Surveyor;

class SurveyTest {
	
	private Survey survey= new Survey();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSid() {
		long mockId = 101;
		survey.setSid(mockId);
		
		long id = survey.getSid();

		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testSetSid() {
		long mockId = 101;
		survey.setSid(mockId);
		
		long id = survey.getSid();

		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testGetRespondent() {	
		Respondent mockR = new Respondent();
		mockR.setRespondentId(501);
		
		List<Respondent> mockRes = new ArrayList<Respondent>();
		mockRes.add(mockR);
		
		survey.setRespondent(mockRes);
		
		List<Respondent> res= survey.getRespondent();
	
		assertThat(res).isEqualTo(mockRes);
	}

	@Test
	void testSetRespondent() {
		Respondent mockR = new Respondent();
		mockR.setRespondentId(501);
		
		List<Respondent> mockRes = new ArrayList<Respondent>();
		mockRes.add(mockR);
		
		survey.setRespondent(mockRes);
		
		List<Respondent> res= survey.getRespondent();
	
		assertThat(res).isEqualTo(mockRes);
	}

	@Test
	void testGetStatus() {
		String mockStatus = "Passive";
		survey.setStatus(mockStatus);
		
		String status = survey.getStatus();

		assertThat(status).isEqualTo(mockStatus);
	}

	@Test
	void testSetStatus() {
		String mockStatus = "Passive";
		survey.setStatus(mockStatus);
		
		String status = survey.getStatus();

		assertThat(status).isEqualTo(mockStatus);
	}

	@Test
	void testGetSurveyor() {
		Surveyor mockS = new Surveyor();
		mockS.setSurveyorId(501);
		
	
		survey.setSurveyor(mockS);
		
		Surveyor s = survey.getSurveyor();

		assertThat(s).isEqualTo(mockS);
	}

	@Test
	void testSetSurveyor() {
		Surveyor mockS = new Surveyor();
		mockS.setSurveyorId(501);
		
	
		survey.setSurveyor(mockS);
		
		Surveyor s = survey.getSurveyor();

		assertThat(s).isEqualTo(mockS);
	}

	@Test
	void testGetTitle() {
		String mockTitle = "title";
		survey.setTitle(mockTitle);
		
		String title = survey.getTitle();

		assertThat(title).isEqualTo(mockTitle);
	}

	@Test
	void testSetTitle() {
		String mockTitle = "title";
		survey.setTitle(mockTitle);
		
		String title = survey.getTitle();

		assertThat(title).isEqualTo(mockTitle);
	}

	@Test
	void testGetDueDate() {
		String mockDate = "10/12/2020";
		survey.setDueDate(mockDate);
		
		String date = survey.getDueDate();

		assertThat(date).isEqualTo(mockDate);
	}

	@Test
	void testSetDueDate() {
		String mockDate = "10/12/2020";
		survey.setDueDate(mockDate);
		
		String date = survey.getDueDate();

		assertThat(date).isEqualTo(mockDate);
	}

	@Test
	void testGetQuestions() {
		Question mockQ = new Question();
		mockQ.setQid(501);
		
		List<Question> mockQue = new ArrayList<Question>();
		mockQue.add(mockQ);
		
		survey.setQuestions(mockQue);
		
		List<Question> ques= survey.getQuestions();

		assertThat(ques).isEqualTo(mockQue);
	}

	@Test
	void testSetQuestions() {
		Question mockQ = new Question();
		mockQ.setQid(501);
		
		List<Question> mockQue = new ArrayList<Question>();
		mockQue.add(mockQ);
		
		survey.setQuestions(mockQue);
		
		List<Question> ques= survey.getQuestions();

		assertThat(ques).isEqualTo(mockQue);
	}

	@Test
	void testSetFeedback() {
		Float mockFeed = (float) 4.5;
		survey.setFeedback(mockFeed);
		
		Float feed = survey.getFeedback();

		assertThat(feed).isEqualTo(mockFeed);
	}

	@Test
	void testGetFeedback() {
		Float mockFeed = (float) 4.5;
		survey.setFeedback(mockFeed);
		
		Float feed = survey.getFeedback();

		assertThat(feed).isEqualTo(mockFeed);
	}

}
