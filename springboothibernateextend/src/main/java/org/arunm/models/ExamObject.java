package org.arunm.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="OBJECT_TYPE")
public abstract class ExamObject {

	 	@Id
	 	@GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;

	 	@ManyToOne(fetch = FetchType.LAZY)
	 	@JoinColumn(name = "examid", nullable = false)
	 	private Exam exam;
	 	
	 	
		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Exam getExam() {
			return exam;
		}


		public void setExam(Exam exam) {
			this.exam = exam;
		}
		
		
}
