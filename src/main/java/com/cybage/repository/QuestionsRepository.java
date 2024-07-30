package com.cybage.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entity.Questions;
import com.cybage.entity.Quize;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
	List<Questions> findByQuize(Quize quize);
}
