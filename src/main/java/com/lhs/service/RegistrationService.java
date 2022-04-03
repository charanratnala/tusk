package com.lhs.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lhs.customexception.GlobalExceptionHandler;
import com.lhs.dao.RegistrationRepo;
import com.lhs.dao.Rolerepo;
import com.lhs.dto.RegistrationDto;
import com.lhs.entity.RegistrationEntity;
import com.lhs.entity.Roles;

@Service
public class RegistrationService implements RegistrationServiceInterface {

	@Autowired
	RegistrationRepo repo;
	@Autowired
	Rolerepo rolerepo;

	public void addAccount(RegistrationDto register) {
		RegistrationEntity entity = new RegistrationEntity();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(register, entity);

		PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		if (repo.existsByUsername(entity.getUsername()))

			throw new GlobalExceptionHandler("501", "already existed username found");

		else

			entity.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));

		Roles rol = rolerepo.findByRolename(register.getRolen());

		Roles r = new Roles();
		r.setRolename(register.getRolen());
		entity.setRole(new ArrayList<Roles>());
		entity.getRole().add(r);
		repo.save(entity);
	
		

	}

	public int add(int i,int b)
	{
		RegistrationEntity entity = new RegistrationEntity();

		if(i==0)
		throw new RuntimeException("cc");
		else
			
			
			repo.save(entity);
		return 0;
		
	}
}
