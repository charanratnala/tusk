package com.lhs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.Roles;

@Repository
public interface Rolerepo extends CrudRepository<Roles, Integer> {

	Roles findByRolename(String rolename);

}
