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
import com.surveybuilder.enitity.Respondent;
import com.surveybuilder.repository.RespondentRepository;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = RespondentService.class)
class RespondentServiceTest {

	@Autowired
	private RespondentService respondentService;
	   
	@MockBean
	private RespondentRepository respondentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateRespondentController() throws Exception {
		Respondent respondent = getRespondent();
	   
	    Mockito.when(respondentRepository.save(Mockito.any(Respondent.class))).thenReturn(respondent);
	    
	    Respondent result = respondentService.createRespondentService(respondent);
	    
	    assertThat(respondent).isEqualTo(result);

	}

	@Test
	void testViewRespondentByIdController() throws Exception {
		
		Respondent respondent = getRespondent();

	    Mockito.when(respondentRepository.findRespondentById(Mockito.anyLong())).thenReturn(respondent);

	    Respondent result = respondentService.viewRespondentByIdService(101);
	    
	    assertThat(respondent).isEqualTo(result);

	}

	@Test
	void testUpdateRespondentController() throws Exception {
		
		Optional<Respondent> a = Optional.of(getRespondent());
		
		
		Respondent respondent = getRespondent();
	  
	    Mockito.when(respondentRepository.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(respondentRepository.save(Mockito.any(Respondent.class))).thenReturn(respondent);
	    
	    Respondent result = respondentService.updateRespondentService(respondent, 101);
	    
	    assertThat(respondent).isEqualTo(result);
	}

	@Test
	void testDeleteRespondentByIdController() throws Exception {
		Optional<Respondent> a = Optional.of(getRespondent());

	    boolean b = true;
	    
	    Mockito.when(respondentRepository.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(respondentRepository).deleteById(Mockito.anyLong());
	    
	    boolean result = respondentService.deleteRespondentByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllRespondentController() throws Exception {

		List<Respondent> a = new ArrayList<Respondent>();
		
		Respondent respondent = getRespondent();
		a.add(respondent);
	    
	    Mockito.when(respondentRepository.findAll()).thenReturn(a);
	   
	    List<Respondent> result = respondentService.listAllRespondentService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private Respondent getRespondent() {
		Respondent a = new Respondent();
		
		a.setRespondentId(101);
		a.setEmailId("abc");
		a.setName("abc");
		a.setPassword("abc");
		
		return a;
	}


}
