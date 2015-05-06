package org.arunm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OnetoOneFoo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fooId;
	
	@OneToOne
	@JoinColumn(name="bar_barId")
	private OnetoOneBar onetoOneBar;
	
	
	private String fooDesc;


	public int getFooId() {
		return fooId;
	}


	public void setFooId(int fooId) {
		this.fooId = fooId;
	}



	public OnetoOneBar getOnetoOneBar() {
		return onetoOneBar;
	}


	public void setOnetoOneBar(OnetoOneBar onetoOneBar) {
		this.onetoOneBar = onetoOneBar;
	}


	public String getFooDesc() {
		return fooDesc;
	}


	public void setFooDesc(String fooDesc) {
		this.fooDesc = fooDesc;
	}
	
	@Override
	public String toString() {
		return fooId + " " +  "fooDesc" + "onetoOneBar -{" + onetoOneBar + "}";
	}
	
}
