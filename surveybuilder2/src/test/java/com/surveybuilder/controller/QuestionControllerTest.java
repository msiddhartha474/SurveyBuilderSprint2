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
import com.surveybuilder.enitity.Question;
import com.surveybuilder.service.QuestionService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = QuestionController.class)
class QuestionControllerTest {


	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private QuestionService questionService;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateQuestionService() throws Exception {
		String URI = "/createQuestion";
		Question question = getQuestion();
	    String jsonInput = this.converttoJson(question);

	    Mockito.when(questionService.createQuestionService(Mockito.any(Question.class))).thenReturn(question);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testViewQuestionByIdService() throws Exception {
		String URI = "/viewQuestionById/{id}";
		Question question = getQuestion();
	    String jsonInput = this.converttoJson(question);

	    Mockito.when(questionService.viewQuestionByIdService(Mockito.anyLong())).thenReturn(question);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testUpdateQuestionService() throws Exception {
		String URI = "/updateQuestion/{id}";
		Question question = getQuestion();
	    String jsonInput = this.converttoJson(question);

	    Mockito.when(questionService.updateQuestionService(Mockito.any(Question.class), Mockito.anyLong())).thenReturn(question);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 101).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn(); MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteQuestionByIdService() throws Exception {
		String URI = "/deleteQuestionById/{id}";
 
	    String r = "Record deleted Successfully";
	    Boolean b = true;
	    
	    Mockito.when(questionService.deleteQuestionByIdService(Mockito.anyLong())).thenReturn(b);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(r).isEqualTo(jsonOutput);
	   
	}

	@Test
	void testListAllQuestionService() throws Exception {
		String URI = "/listAllQuestion";
		List<Question> a = new ArrayList<Question>();
		
		Question question = getQuestion();
		a.add(question);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(questionService.listAllQuestionService()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	
	private Question getQuestion() {
		Question a = new Question();
		
		a.setQid(101);
		a.setQuestion("Question 1");
		a.setOption1("option1");
		a.setOption2("option2");
		a.setOption3("option3");
		a.setOption4("option4");

		return a;
	}
	
	
	private String converttoJson(Object question) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(question);
	}
	

}
