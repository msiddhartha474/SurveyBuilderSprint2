package com.surveybuilder.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.surveybuilder.SurveyBuilderApplication;
import com.surveybuilder.enitity.Survey;
import com.surveybuilder.service.SurveyService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = SurveyController.class)
class SurveyControllerTest {


	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private SurveyService surveyService;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateSurveyService() throws Exception {
		String URI = "/createSurvey";
		Survey survey = getSurvey();
	    String jsonInput = this.converttoJson(survey);

	    Mockito.when(surveyService.createSurveyService(Mockito.any(Survey.class))).thenReturn(survey);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testViewSurveyByIdService() throws Exception {
		String URI = "/viewSurveyById/{id}";
		Survey survey = getSurvey();
	    String jsonInput = this.converttoJson(survey);

	    Mockito.when(surveyService.viewSurveyByIdService(Mockito.anyLong())).thenReturn(survey);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testUpdateSurveyService() throws Exception {
		String URI = "/updateSurvey/{id}";
		Survey survey = getSurvey();
	    String jsonInput = this.converttoJson(survey);

	    Mockito.when(surveyService.updateSurveyService(Mockito.any(Survey.class), Mockito.anyLong())).thenReturn(survey);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 101).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn(); MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteSurveyByIdService() throws Exception {
		String URI = "/deleteSurveyById/{id}";
 
	    String r = "Record deleted Successfully";
	    boolean b = true;
	    
	    Mockito.when(surveyService.deleteSurveyByIdService(Mockito.anyLong())).thenReturn(b);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(r).isEqualTo(jsonOutput);
	    
	}

	@Test
	void testListAllSurveyService() throws Exception {
		String URI = "/listAllSurvey";
		List<Survey> a = new ArrayList<Survey>();
		
		Survey survey = getSurvey();
		a.add(survey);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(surveyService.listAllSurveyService()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
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
	
	
	private String converttoJson(Object survey) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(survey);
	}
	

}
