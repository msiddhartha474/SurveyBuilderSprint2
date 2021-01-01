package com.surveybuilder.enitity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Respondent")
public class Respondent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long respondentId;
	
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String name;
	
	@Email(message = "Email should be valid")
	private String emailId;
	
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	private String password;
	
	
	@ManyToMany(mappedBy="respondent",cascade = CascadeType.ALL,fetch = FetchType.LAZY, targetEntity = Survey.class)
	private List<Survey> surveys = new ArrayList<Survey>();
	 
	
	
	public long getRespondentId() {
		return respondentId;
	}
	public void setRespondentId(long respondentId) {
		this.respondentId = respondentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String eId) {
		this.emailId = eId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Survey> getSurveys() {
		return surveys;
	}
	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}
	
	
}
