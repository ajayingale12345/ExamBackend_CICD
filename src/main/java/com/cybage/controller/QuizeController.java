package com.cybage.controller;

import java.util.List;

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
import com.cybage.entity.Quize;
import com.cybage.service.QuizeService;

import net.bytebuddy.asm.Advice.This;

@RestController
@CrossOrigin
@RequestMapping("/quize")
public class QuizeController {
	@Autowired
	private QuizeService quizeService;
	@PostMapping("")
	public ResponseEntity<Quize>addQuize(@RequestBody Quize quize){
		System.out.println(quize);
		return new ResponseEntity<Quize>(this.quizeService.addQuize(quize),HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Quize>updateQuize(@RequestBody Quize quize){
		return new ResponseEntity<Quize>(this.quizeService.addQuize(quize),HttpStatus.OK);
		
	}
	@GetMapping("/")
	
	public ResponseEntity <List<Quize>> getQuizes(){
		return new ResponseEntity <List<Quize>>(this.quizeService.getQuizes(),HttpStatus.OK);
		
	}
	@GetMapping("/{qid}")
	public ResponseEntity<Quize>updateQuize(@PathVariable("qid")  int qid){
		return new ResponseEntity<Quize>(this.quizeService.getQuize(qid),HttpStatus.OK);
		
	}
	@DeleteMapping("/{qid}")
	public void deleteQuize(@PathVariable("qid")  int qid){
		 this.quizeService.deleteQuize(qid);
	}
	@GetMapping("/catagory/{cid}")
	public ResponseEntity <List<Quize>> getcatagoryQuize(@PathVariable("cid")  Long cid){
		Catagory catagory=new Catagory();
		System.out.println(cid);
		catagory.setCid(cid);
		return new ResponseEntity <List<Quize>>(this.quizeService.getQuizesOfCatgory(catagory),HttpStatus.OK);
		
	}
	@GetMapping("/active")
	public  ResponseEntity<List<Quize>>getActiveQuizes(){
		return new ResponseEntity<List<Quize>>(this.quizeService.getActiveQuizes(),HttpStatus.OK);
	}
	@GetMapping("/catagory/active/{cid}")
	public  ResponseEntity<List<Quize>>getActiveQuizesOfCategory(@PathVariable("cid") Long cid){
		Catagory catagory=new Catagory();
		catagory.setCid(cid);
		return new ResponseEntity<List<Quize>>(this.quizeService.getActiveQuizesOfCategory(catagory),HttpStatus.OK);
	}
}
