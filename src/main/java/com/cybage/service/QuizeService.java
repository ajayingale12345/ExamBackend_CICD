package com.cybage.service;

import java.util.List;
import java.util.Set;

import com.cybage.entity.Catagory;
import com.cybage.entity.Quize;



public interface QuizeService {
	public Quize addQuize(Quize quize);
	public Quize updateQuize(Quize quize);
	public List<Quize> getQuizes( );
	public  Quize getQuize(int quizeId );
	public void deleteQuize(int quizeId);
	public List<Quize> getQuizesOfCatgory(Catagory catagory);
	public List<Quize>getActiveQuizes();
	public List<Quize>getActiveQuizesOfCategory(Catagory c);
	

}
