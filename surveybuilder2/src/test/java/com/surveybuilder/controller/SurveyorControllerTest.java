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
import com.surveybuilder.enitity.Surveyor;
import com.surveybuilder.service.SurveyorService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SurveyBuilderApplication.class)
@WebMvcTest(value = SurveyorController.class)
class SurveyorControllerTest {


	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private SurveyorService surveyorService;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateSurveyorService() throws Exception {
		String URI = "/createSurveyor";
		Surveyor surveyor = getSurveyor();
	    String jsonInput = this.converttoJson(surveyor);

	    Mockito.when(surveyorService.createSurveyorService(Mockito.any(Surveyor.class))).thenReturn(surveyor);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testViewSurveyorByIdService() throws Exception {
		String URI = "/viewSurveyorById/{id}";
		Surveyor surveyor = getSurveyor();
	    String jsonInput = this.converttoJson(surveyor);

	    Mockito.when(surveyorService.viewSurveyorByIdService(Mockito.anyLong())).thenReturn(surveyor);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	void testUpdateSurveyorService() throws Exception {
		String URI = "/updateSurveyor/{id}";
		Surveyor surveyor = getSurveyor();
	    String jsonInput = this.converttoJson(surveyor);

	    Mockito.when(surveyorService.updateSurveyorService(Mockito.any(Surveyor.class), Mockito.anyLong())).thenReturn(surveyor);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 101).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn(); MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteSurveyorByIdService() throws Exception {
		String URI = "/deleteSurveyorById/{id}";
 
	    String r = "Record deleted Successfully";
	    boolean b = true;
	    
	    Mockito.when(surveyorService.deleteSurveyorByIdService(Mockito.anyLong())).thenReturn(b);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(r).isEqualTo(jsonOutput);
	   
	}

	@Test
	void testListAllSurveyorService() throws Exception {
		String URI = "/listAllSurveyor";
		List<Surveyor> a = new ArrayList<Surveyor>();
		
		Surveyor surveyor = getSurveyor();
		a.add(surveyor);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(surveyorService.listAllSurveyorService()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	
	private Surveyor getSurveyor() {
		Surveyor a = new Surveyor();
		
		a.setSurveyorId(101);
		a.setEmailId("a");
		a.setName("a");
		a.setPassword("a");
		

		return a;
	}
	
	
	private String converttoJson(Object surveyor) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(surveyor);
	}
	

}
