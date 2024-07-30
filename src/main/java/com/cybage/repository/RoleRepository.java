package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
