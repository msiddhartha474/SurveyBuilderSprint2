package com.surveybuilder.enitity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Surveyor")
public class Surveyor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long surveyorId;
	
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String name;
	
	@Email(message = "Email should be valid")
	private String emailId;
	
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	private String password;
	
	@OneToMany(mappedBy = "surveyor", fetch = FetchType.LAZY, targetEntity = Survey.class, cascade = CascadeType.ALL)	
	private List<Survey> surveys;
	
	
	
	public long getSurveyorId() {
		return surveyorId;
	}
	public void setSurveyorId(long surveyorId) {
		this.surveyorId = surveyorId;
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
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	
	@Override
	public String toString() {
		return "\nSurveyor Id : "+this.getSurveyorId()
		+"\nName : "+this.getName()
		+"\nEmail Id : "+this.getEmailId()
		+"\nPassword : "+this.getPassword()+"\n";
	}
	
	
}
