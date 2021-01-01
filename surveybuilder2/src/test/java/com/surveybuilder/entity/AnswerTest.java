package com.surveybuilder.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.surveybuilder.enitity.Answer;
import com.surveybuilder.enitity.Question;

class AnswerTest {

	private Answer answer = new Answer();
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetQue() {
		Question mockq = new Question();
		mockq.setQid(501);
		
		answer.setQue(mockq);
		
		Question q = answer.getQue();
		assertThat(q).isEqualTo(mockq);
	}

	@Test
	void testSetQue() {
		Question mockq = new Question();
		mockq.setQid(501);
		
		answer.setQue(mockq);
		
		Question q = answer.getQue();
		assertThat(q).isEqualTo(mockq);
	}

	@Test
	void testGetAns() {
		String mockAns = "Opt1";
		answer.setAns(mockAns);
		String ans = answer.getAns();
		
		assertThat(ans).isEqualTo(mockAns);
	}

	@Test
	void testSetAns() {
		String mockAns = "Opt1";
		answer.setAns(mockAns);
		String ans = answer.getAns();
		
		assertThat(ans).isEqualTo(mockAns);
	}

	@Test
	void testGetAid() {
		long mockId = 101;
		answer.setAid(mockId);
		long id = answer.getAid();
		
		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testSetAid() {
		long mockId = 101;
		answer.setAid(mockId);
		long id = answer.getAid();
		
		assertThat(id).isEqualTo(mockId);
	}

}
