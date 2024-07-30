package com.cybage.serviceImpl;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.entity.Catagory;
import com.cybage.entity.Quize;
import com.cybage.repository.QuizesRepository;
import com.cybage.service.QuizeService;
@Service
public class QuizeServiceImpl implements QuizeService {
	@Autowired
	private QuizesRepository quizesRepository;

	@Override
	public Quize addQuize(Quize quize) {
		
		return this.quizesRepository.save(quize);
	}

	@Override
	public Quize updateQuize(Quize quize) {
	
		return  this.quizesRepository.save(quize);
	}

	@Override
	public List<Quize> getQuizes() {
		
		return  this.quizesRepository.findAll();
	}

	@Override
	public Quize getQuize(int  quizeId) {
		
		return this.quizesRepository.findById(quizeId).get();
	}

	@Override
	public void deleteQuize(int quizeId) {
		Quize quize=new Quize();
		quize.setQId(quizeId);
		this.quizesRepository.delete(quize);
		
	}

	@Override
	public List<Quize> getQuizesOfCatgory(Catagory catagory) {
		
		return this.quizesRepository.findBycatagory(catagory);
	}

	@Override
	public List<Quize> getActiveQuizes() {
	
		return this.quizesRepository.findByActive(true);
	}

	@Override
	public List<Quize> getActiveQuizesOfCategory(Catagory c) {
	
		return this.quizesRepository.findByCatagoryAndActive(c, true);
	}

}
