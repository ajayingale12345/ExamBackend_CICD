package com.cybage.service;

import java.util.List;
import java.util.Set;

import com.cybage.entity.Questions;
import com.cybage.entity.Quize;

public interface QuestionsService {
	public Questions addQuestion(Questions question);
	public Questions updateQuestion(Questions question);
	public List<Questions> getQuestions( );
	public Questions getQuestion(int questionId);
	public List<Questions> getQuestionsOfQuize( Quize quize);
	public void deleteQuestion(int qid);

}
