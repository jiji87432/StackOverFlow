package org.arunm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnetoOneBar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int barId;
	
	private String barDesc;

	public int getBarId() {
		return barId;
	}

	public void setBarId(int barId) {
		this.barId = barId;
	}

	public String getBarDesc() {
		return barDesc;
	}

	public void setBarDesc(String barDesc) {
		this.barDesc = barDesc;
	}

	@Override
	public String toString() {
		return "OnetoOneBar [barId=" + barId + ", barDesc=" + barDesc + "]";
	}
	
}
