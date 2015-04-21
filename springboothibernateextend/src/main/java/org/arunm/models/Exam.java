package org.arunm.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer examid;
	
	private String examName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exam")
	private Set<ExamObject> objects;



	public Integer getExamid() {
		return examid;
	}



	public void setExamid(Integer examid) {
		this.examid = examid;
	}



	public Set<ExamObject> getObjects() {
		return objects;
	}



	public void setObjects(Set<ExamObject> objects) {
		this.objects = objects;
	}



	public String getExamName() {
		return examName;
	}



	public void setExamName(String examName) {
		this.examName = examName;
	}
	 
	 
}
