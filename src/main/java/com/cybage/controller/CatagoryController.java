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

import com.cybage.entity.Catagory;
import com.cybage.service.CatagoryService;
@CrossOrigin
@RestController
@RequestMapping("/category")
public class CatagoryController {
	@Autowired
	private CatagoryService catagoryService;
	//Add catagory
	@PostMapping("/")
	public ResponseEntity<Catagory>addCatagory(@RequestBody Catagory catagory){
		Catagory catagory1=this.catagoryService.addCatagory(catagory);
		
		return new ResponseEntity<Catagory>(catagory1,HttpStatus.OK);
		
	}
	@GetMapping("/{catagoryId}")
	public ResponseEntity<Catagory>getCatagory(@PathVariable("catagoryId") Long catagoryId){
		System.out.println(catagoryId);
		Catagory catagory1=this.catagoryService.getCatagory(catagoryId);
		
		
		return new ResponseEntity<Catagory>(catagory1,HttpStatus.OK);
		
	}
	@GetMapping("/")
	public ResponseEntity <List<Catagory>> getCatagories(){
		
		
		return new ResponseEntity   <List<Catagory>>(this.catagoryService.getCatagories(),HttpStatus.OK);
		
	}
	@PutMapping("/")
	public ResponseEntity<Catagory>updateCatagory(@RequestBody Catagory catagory){
		Catagory catagory1=this.catagoryService.addCatagory(catagory);
		
		return new ResponseEntity<Catagory>(catagory1,HttpStatus.OK);
		
	}
	@DeleteMapping("/{catagoryId}")
	public void deleteCatagory(@PathVariable("catagoryId") Long catagoryId){

		 this.catagoryService.deleteCatagory(catagoryId);
		
	}

}
