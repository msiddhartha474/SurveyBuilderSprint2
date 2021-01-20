package com.surveybuilder.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.surveybuilder.SurveyBuilderApplication;
import com.surveybuilder.enitity.Survey;
import com.surveybuilder.repository.SurveyRepository;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = SurveyService.class)
class SurveyServiceTest {

	@Autowired
	private SurveyService surveyService;
	   
	@MockBean
	private SurveyRepository surveyRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateSurveyController() throws Exception {
		Survey survey = getSurvey();
	   
	    Mockito.when(surveyRepository.save(Mockito.any(Survey.class))).thenReturn(survey);
	    
	    Survey result = surveyService.createSurveyService(survey);
	    
	    assertThat(survey).isEqualTo(result);

	}

	@Test
	void testViewSurveyByIdController() throws Exception {
		
		Survey survey = getSurvey();

	    Mockito.when(surveyRepository.findSurveyById(Mockito.anyLong())).thenReturn(survey);

	    Survey result = surveyService.viewSurveyByIdService(101);
	    
	    assertThat(survey).isEqualTo(result);

	}

	@Test
	void testUpdateSurveyController() throws Exception {
		
		Optional<Survey> a = Optional.of(getSurvey());
		
		
		Survey survey = getSurvey();
	  
	    Mockito.when(surveyRepository.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(surveyRepository.save(Mockito.any(Survey.class))).thenReturn(survey);
	    
	    Survey result = surveyService.updateSurveyService(survey);
	    
	    assertThat(survey).isEqualTo(result);
	}

	@Test
	void testDeleteSurveyByIdController() throws Exception {
		Optional<Survey> a = Optional.of(getSurvey());

	    boolean b = true;
	    
	    Mockito.when(surveyRepository.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(surveyRepository).deleteById(Mockito.anyLong());
	    
	    boolean result = surveyService.deleteSurveyByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllSurveyController() throws Exception {

		List<Survey> a = new ArrayList<Survey>();
		
		Survey survey = getSurvey();
		a.add(survey);
	    
	    Mockito.when(surveyRepository.findAll()).thenReturn(a);
	   
	    List<Survey> result = surveyService.listAllSurveyService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private Survey getSurvey() {
Survey a = new Survey();
		
		a.setSid(101);
		a.setTitle("Survey");
		a.setDueDate("31/12/2020");
		a.setFeedback(0);
		a.setStatus("passive");

		return a;
	}


}
