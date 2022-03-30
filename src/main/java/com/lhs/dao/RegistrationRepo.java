package com.lhs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.RegistrationEntity;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Integer> {

	boolean existsByUsername(String username);

	RegistrationEntity findByUsername(String username);

}
