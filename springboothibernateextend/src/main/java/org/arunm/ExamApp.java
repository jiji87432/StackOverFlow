package org.arunm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.arunm.models.Exam;
import org.arunm.models.ExamObject;
import org.arunm.models.ExamQuestion;
import org.arunm.models.ExamQuestionRepository;
import org.arunm.models.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class ExamApp implements CommandLineRunner {
	@Autowired
	private ExamQuestionRepository examQuestionRepository;
	
	@Autowired
	private ExamRepository examRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamApp.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		
		//createExam();
		getExam();
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	private void getExam(){
		Iterable<Exam> examGet = examRepository.findAll();
		for (Exam exam2: examGet) {
			 System.out.println("Exam question is .. " + exam2.getObjects());
		}

	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	private void createExam() {
		
	Exam exam = new Exam();
	exam.setExamName("Exam1");
	examRepository.save(exam);
	
	String[] questions = new String[]{"Question1,Question2"};
	Set<ExamObject> examQuestions = new HashSet<ExamObject>();
	int index = 0;
	for(String questionNoDesc: questions){
		index++;
		ExamQuestion examQuestion = new ExamQuestion();
		examQuestion.setQuestionDesc(questionNoDesc);
		examQuestion.setQuestionNumber(index);
		examQuestion.setExam(exam);
		examQuestions.add(examQuestion);
	}
	examQuestionRepository.save(examQuestions);
	
	exam.setObjects(examQuestions);
	
	}


	private void createExamQuestion(Exam exam,String... questions) {
		
		ArrayList<ExamQuestion> examQuestions = new ArrayList<ExamQuestion>();
		int index = 0;
		for(String questionNoDesc: questions){
			index++;
			ExamQuestion examQuestion = new ExamQuestion();
			examQuestion.setQuestionDesc(questionNoDesc);
			examQuestion.setQuestionNumber(index);
			examQuestion.setExam(exam);
			examQuestions.add(examQuestion);
		}
		examQuestionRepository.save(examQuestions);
	}

}
