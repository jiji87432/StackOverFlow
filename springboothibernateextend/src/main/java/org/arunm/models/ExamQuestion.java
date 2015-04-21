package org.arunm.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@DiscriminatorValue("Q")
public class ExamQuestion extends ExamObject{

	 private Integer questionNumber;
	 
	 private String questionDesc;

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	 
	 @Override
	public String toString() {
		return "Question No: " + questionNumber + " Description " + questionDesc;
	}
}
