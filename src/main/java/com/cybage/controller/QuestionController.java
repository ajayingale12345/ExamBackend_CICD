package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entity.Questions;
import com.cybage.entity.Quize;
import com.cybage.service.QuestionsService;
import com.cybage.service.QuizeService;

import lombok.ToString;



@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuizeService quizeService;
	@PostMapping("/")
	public ResponseEntity<Questions>addQusestions(@RequestBody Questions question){
		System.out.println("Hello Ajay");
		System.out.println(question);
	      Quize quize=quizeService.getQuize(question.getQuize().getQId());
	       question.setQuize(quize);
		 
		return new ResponseEntity<Questions>(this.questionsService.addQuestion(question),HttpStatus.OK);
	}
	@PutMapping("")
	public ResponseEntity<Questions>updateQuestions(@RequestBody Questions question){
		return new ResponseEntity<Questions>(this.questionsService.updateQuestion(question),HttpStatus.OK);
	}
	@GetMapping("/quize/{qid}")
	public ResponseEntity <List<Questions>>getQuestionsOfQuize(@PathVariable("qid") int qid){
//		Quize quize =new Quize();
//		quize.setQId(qid);
//		List<Questions>QuestionsOfQuize=this.questionsService.getQuestionsOfQuize(quize);
//		return new ResponseEntity <List<Questions>> (this.questionsService.getQuestions(),HttpStatus.OK);
		Quize quize =this.quizeService.getQuize(qid);
		Set<Questions>questions=quize.getQuestions();
		List<Questions>list=new ArrayList<Questions>(questions);
		if(list.size()>Integer.parseInt(quize.getMaxMarks())) {
			list=list.subList(0, Integer.parseInt(quize.getNumberOfQuestions()+1));
			
		}
//		Collections.shuffle(list);
		return new ResponseEntity<List<Questions>>(list,HttpStatus.OK);
		
	}
	@GetMapping("/quize/all/{qid}")
	public ResponseEntity <List<Questions>>getQuestionsOfQuizeaAdmin(@PathVariable("qid") int qid){
       Quize quize=new Quize();
       quize.setQId(qid);
       System.out.println(quize);
       List<Questions>questionsOfQuize=this.questionsService.getQuestionsOfQuize(quize);
		return new ResponseEntity<List<Questions>>(questionsOfQuize,HttpStatus.OK);
		
	}
	@GetMapping("/{qid}")
	public Questions getQuestions(@PathVariable("qid") int qid) {
		return this.questionsService.getQuestion(qid);
		
	}
	@DeleteMapping("/{qid}")
	public void deleteQuestion(@PathVariable("qid") int qid) {
		 this.questionsService.deleteQuestion(qid);
	}
	
	
}
