package com.cybage.repository;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entity.Catagory;
import com.cybage.entity.Quize;

@Repository
public interface QuizesRepository extends JpaRepository<Quize, Integer>{
	public List<Quize>findBycatagory(Catagory catagory);
	public List<Quize >findByActive(Boolean b);
	public List<Quize>findByCatagoryAndActive(Catagory c,Boolean b);
	

}
