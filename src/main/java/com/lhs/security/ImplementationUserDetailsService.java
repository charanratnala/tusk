package com.lhs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lhs.customexception.GlobalExceptionHandler;
import com.lhs.dao.RegistrationRepo;
import com.lhs.entity.RegistrationEntity;

@Service
public class ImplementationUserDetailsService implements UserDetailsService {

	@Autowired
	RegistrationRepo registrationRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		RegistrationEntity reg = registrationRepo.findByUsername(username);
		if (reg == null) {

			throw new GlobalExceptionHandler("707", "error found in user details class 26");

		}
		return new ImpleUserDetails(reg);

	}

}
