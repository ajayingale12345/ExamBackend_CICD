package com.cybage.entity;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "quize")
@ToString
public class Quize {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int qId;
	private String description;
	private String title;
	private String maxMarks;
	private String numberOfQuestions;
	private boolean active=false;
		@ManyToOne(fetch = FetchType.EAGER)
	private Catagory catagory;
	@OneToMany(mappedBy = "quize",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
	private java.util.Set<Questions>questions=new HashSet<Questions>();
	

}
