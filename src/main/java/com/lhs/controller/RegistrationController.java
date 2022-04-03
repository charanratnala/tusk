package com.lhs.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.customexception.GlobalExceptionHandler;
import com.lhs.dao.RegistrationRepo;
import com.lhs.dto.RegistrationDto;
import com.lhs.entity.RegistrationEntity;
import com.lhs.security.ImplementationUserDetailsService;
import com.lhs.security.JWTUtility;
import com.lhs.security.JwtRequest;
import com.lhs.security.JwtResponse;
import com.lhs.service.RegistrationService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class RegistrationController {

	@Autowired
	AuthenticationManager authenticationManager;

	Logger logger = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	JWTUtility jwtUtility;

	@Autowired
	ImplementationUserDetailsService detailsService;

	@Autowired
	RegistrationRepo registrationRepo;

	@Autowired
	RegistrationService service;

	@PostMapping("/check")
	public String home() {
		logger.info("checking  page  ");
		return "Hii Dude";
	}

	@PostMapping("/login")
	public String loginPage() {
		logger.info("login method executed");
		return "login";
	}

	@RequestMapping("/logg")
	public String logout() {
		logger.info("logout called");
		return "logout";
	}

	@PostMapping("/register")
	public ResponseEntity<String> addRegistration(@RequestBody @Valid RegistrationDto register) {

		logger.info("executed add method in controller");
		if (register == null) {
			logger.error("registration object is null");
		}

		service.addAccount(register);
		logger.info("account saved in the database sucessfully");

		return ResponseEntity.ok("added account sucessfully " + register.getUsername());

	}

	@PostMapping("/authorization")
	public JwtResponse getResponse(@RequestBody JwtRequest jwtRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getPassword(), jwtRequest.getUsername()));

		}

		catch (BadCredentialsException e) {
			

			throw new GlobalExceptionHandler("700", "error in jwt");
		}

		UserDetails user = detailsService.loadUserByUsername(jwtRequest.getUsername());

		String token = jwtUtility.generateToken(user);
		return new JwtResponse(token);

	}

	@GetMapping("/get")
	public Iterable<RegistrationEntity> get() {

		Iterable<RegistrationEntity> entity = registrationRepo.findAll();

		return entity;

	}
	
	
	@PostMapping("/ifconditionlogin")
	public ResponseEntity<?> login(@RequestBody RegistrationEntity details) {
		String email = details.getUsername();
		String password = details.getPassword();
		//log.info(email + " " + password); 
		
            java.util.Optional<RegistrationEntity> t=registrationRepo.findByUsernameAndPassword(email, password);
		//Optional<RegistrationEntity> patient = registrationRepo.findByEmailAndPassword(email, password);
		//Optional<Doctor> doctor = doctorService.findByEmailAndPassword(email, password);
		
	
	if (t.isPresent()) {
			return new ResponseEntity<RegistrationEntity>(HttpStatus.OK);
		}
		
	else
		return new ResponseEntity<>("login failed ! please login with valid credentials..", HttpStatus.BAD_REQUEST);
	}
	
	
	

}
