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
import com.surveybuilder.enitity.Respondent;
import com.surveybuilder.service.RespondentService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = RespondentController.class)
class RespondentControllerTest {


	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private RespondentService respondentService;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateRespondentService() throws Exception {
		String URI = "/createRespondent";
		Respondent respondent = getRespondent();
	    String jsonInput = this.converttoJson(respondent);

	    Mockito.when(respondentService.createRespondentService(Mockito.any(Respondent.class))).thenReturn(respondent);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testViewRespondentByIdService() throws Exception {
		String URI = "/viewRespondentById/{id}";
		Respondent respondent = getRespondent();
	    String jsonInput = this.converttoJson(respondent);

	    Mockito.when(respondentService.viewRespondentByIdService(Mockito.anyLong())).thenReturn(respondent);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testUpdateRespondentService() throws Exception {
		String URI = "/updateRespondent/{id}";
		Respondent respondent = getRespondent();
	    String jsonInput = this.converttoJson(respondent);

	    Mockito.when(respondentService.updateRespondentService(Mockito.any(Respondent.class), Mockito.anyLong())).thenReturn(respondent);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 101).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn(); MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteRespondentByIdService() throws Exception {
		String URI = "/deleteRespondentById/{id}";
 
	    String r = "Record deleted Successfully";
	    boolean b = true;
	    
	    Mockito.when(respondentService.deleteRespondentByIdService(Mockito.anyLong())).thenReturn(b);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(r).isEqualTo(jsonOutput);
	   
	}

	@Test
	void testListAllRespondentService() throws Exception {
		String URI = "/listAllRespondent";
		List<Respondent> a = new ArrayList<Respondent>();
		
		Respondent respondent = getRespondent();
		a.add(respondent);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(respondentService.listAllRespondentService()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	
	private Respondent getRespondent() {
		Respondent a = new Respondent();
		
		a.setRespondentId(101);
		a.setEmailId("a");
		a.setName("a");
		a.setPassword("a");

		return a;
	}
	
	
	private String converttoJson(Object respondent) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(respondent);
	}
	

}
