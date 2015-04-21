package org.arunm.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("T")
public class ExamTask extends ExamObject{

	private Integer taskNo;
	
	private String taskDesc;

	public Integer getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(Integer taskNo) {
		this.taskNo = taskNo;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	
}
