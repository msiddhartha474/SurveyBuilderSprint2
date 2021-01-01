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
import com.surveybuilder.enitity.Answer;
import com.surveybuilder.service.AnswerService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = AnswerController.class)
class AnswerControllerTest {


	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private AnswerService answerService;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateAnswerService() throws Exception {
		String URI = "/createAnswer";
		Answer answer = getAnswer();
	    String jsonInput = this.converttoJson(answer);

	    Mockito.when(answerService.createAnswerService(Mockito.any(Answer.class))).thenReturn(answer);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testViewAnswerByIdService() throws Exception {
		String URI = "/viewAnswerById/{id}";
		Answer answer = getAnswer();
	    String jsonInput = this.converttoJson(answer);

	    Mockito.when(answerService.viewAnswerByIdService(Mockito.anyLong())).thenReturn(answer);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testUpdateAnswerService() throws Exception {
		String URI = "/updateAnswer/{id}";
		Answer answer = getAnswer();
	    String jsonInput = this.converttoJson(answer);

	    Mockito.when(answerService.updateAnswerService(Mockito.any(Answer.class), Mockito.anyLong())).thenReturn(answer);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 101).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn(); MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteAnswerByIdService() throws Exception {
		String URI = "/deleteAnswerById/{id}";
 
	    String r = "Record deleted Successfully";
	    boolean b = true;
	    
	    Mockito.when(answerService.deleteAnswerByIdService(Mockito.anyLong())).thenReturn(b);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(r).isEqualTo(jsonOutput);
	 
	}

	@Test
	void testListAllAnswerService() throws Exception {
		String URI = "/listAllAnswer";
		List<Answer> a = new ArrayList<Answer>();
		
		Answer answer = getAnswer();
		a.add(answer);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(answerService.listAllAnswerService()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	
	private Answer getAnswer() {
		Answer a = new Answer();
		
		a.setAid(101);
		a.setAns("option A");
		
		return a;
	}
	
	
	private String converttoJson(Object answer) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(answer);
	}
	

}
