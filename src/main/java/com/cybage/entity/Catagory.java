package com.cybage.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "catagory")
@ToString
public class Catagory {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long cid;
  private String description;
  private String title;
  @OneToMany(mappedBy = "catagory",cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Quize>quizes=new HashSet<Quize>();
  
 
	

}
