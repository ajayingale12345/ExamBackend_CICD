package com.cybage.serviceImpl;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.entity.Questions;
import com.cybage.entity.Quize;
import com.cybage.repository.QuestionsRepository;
import com.cybage.service.QuestionsService;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	@Autowired
	private QuestionsRepository questionsRepository;

	@Override
	public Questions addQuestion(Questions question) {

		return this.questionsRepository.save(question);
	}

	@Override
	public Questions updateQuestion(Questions question) {

		return  this.questionsRepository.save(question);
	}

	@Override
	public List<Questions> getQuestions() {

		return   this.questionsRepository.findAll();
	}

	@Override
	public Questions getQuestion(int questionId) {

		return  this.questionsRepository.getById(questionId);
	}

	@Override
	public List<Questions> getQuestionsOfQuize(Quize quize) {
		 
		return this.questionsRepository.findByQuize(quize);
	}

	@Override
	public void deleteQuestion(int qid) {
		Questions questions=new Questions();
		questions.setQuesId(qid);
		
		this.questionsRepository.delete(questions);
		
	}

}
