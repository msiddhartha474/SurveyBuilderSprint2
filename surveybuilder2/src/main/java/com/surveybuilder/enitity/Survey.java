package com.surveybuilder.enitity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="survey")
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;
	
	private String title;
	

	private String dueDate;
	
	private String status;
	
	private float feedback;
	
	@OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, targetEntity = Question.class,  orphanRemoval = true, cascade = CascadeType.ALL)	
	private List<Question> questions = new ArrayList<Question>();
	
	
	@ManyToOne
	@JoinColumn(name = "SurveyorId")
	private Surveyor surveyor;
	
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name = "Survey_Respondent", 
	 joinColumns = { @JoinColumn(name = "sId") }, 
	 inverseJoinColumns = { @JoinColumn(name = "respondentId") })
	 private List<Respondent> respondent = new ArrayList<Respondent>();
	 

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public List<Respondent> getRespondent() {
		return respondent;
	}

	public void setRespondent(List<Respondent> respondent) {
		this.respondent = respondent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Surveyor getSurveyor() {
		return surveyor;
	}

	public void setSurveyor(Surveyor surveyor) {
		this.surveyor = surveyor;
	}

	public String getTitle() {
		return title;
		
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void setFeedback(float feedback) {
		this.feedback = feedback;
	}

	public float getFeedback() {
		return feedback;
	}
	
	@Override
	public String toString(){
		String msg = "\nSId: " 
		+ this.getSid() + "\nTitle: " 
		+ this.getTitle()+ "\nDue Date: "
		+ this.getDueDate()+ "\nFeedback: "
		+ this.getFeedback();
		
		msg+="\n";
			
		return msg;
	}



}

