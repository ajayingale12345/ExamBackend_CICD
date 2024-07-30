package com.cybage.serviceImpl;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.entity.Catagory;
import com.cybage.repository.CatagoryRepository;
import com.cybage.service.CatagoryService;
@Service
public class CatagoryServiceImpl implements CatagoryService {
	@Autowired
 private CatagoryRepository catagoryRepository;
	@Override
	public Catagory addCatagory(Catagory catagory) {
		
		return catagoryRepository.save(catagory);
	}

	@Override
	public Catagory updateCatagory(Catagory catagory) {
		// TODO Auto-generated method stub
		return this.catagoryRepository.save(catagory);
	}

	@Override
	public List<Catagory> getCatagories() {
		
		return this.catagoryRepository.findAll();
	}

	@Override
	public Catagory getCatagory(Long catogaryId) {
		
		return  this.catagoryRepository.getById(catogaryId);
	}

	@Override
	public void deleteCatagory(Long catogaryId) {
		Catagory catagory=new Catagory();
		  catagory.setCid(catogaryId);
		  this.catagoryRepository.delete(catagory);
		
	}

}
