package com.lhs.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.lhs.controller.RegistrationController;
import com.lhs.customexception.GlobalExceptionHandler;
import com.lhs.entity.RegistrationEntity;
import com.lhs.service.RegistrationService;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class RegistrationRepoTest {

	@InjectMocks
	RegistrationController controller;
	
	static RegistrationEntity register;
	
	

private static 	RegistrationRepo repo;

	
	static RegistrationService service;

	@BeforeAll
	static void get() {
		service= new RegistrationService();
		register = new RegistrationEntity();
		repo=Mockito.mock(RegistrationRepo.class);
	}

	@Test
	@Tag(value = "dev")
	@Order(1)
	void RegistrationRepoTest() {

		register.setFirstname("sai");
		register.setDob("05-08-1998");
		register.setLastname("charan");
		register.setGender("male");
		register.setPassword("charan11");
		register.setRolen("USER");
		repo.save(register);

	}

//	 @Test
//	 @Disabled
//	    public void testAddEmployee() 
//	    {
//	        MockHttpServletRequest request = new MockHttpServletRequest();
//	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//	         
//	        when(service.addAccount((RegistrationDto) any(RegistrationDto.class))).thenReturn(true);
//	         
//	        @Valid RegistrationDto employee = new RegistrationDto();
//	        ResponseEntity<String> responseEntity = RegistrationController.addRegistration(employee);
//	         
//	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
//	        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
//	    }
//	@Test
//	@Disabled
//	ResponseEntity<String> RegistrationControllerTest() {
//		RegistrationDto registerdto = new RegistrationDto();
//		RegistrationDto registerdtoo = new RegistrationDto();
//		registerdtoo.setFirstname("charan");
//		RegistrationEntity savedregister = new RegistrationEntity();
//
//		savedregister.setFirstname("charan");
//		when(service.addAccount(registerdto)).thenReturn(registerdtoo);
//
//	}
	@Test
	@Order(0)
	@DisplayName("simple exception")
	void addTest()
	{ 
		RegistrationService serv= new RegistrationService();
		service.add(2, 3);
		assertThrows( RuntimeException.class,()->{
			serv.add(0,0);
		});
	}
	
	
	
	
	@Test
	public void TestRgistrationservice()
	{
		
		//create a stub 
		register.setFirstname("charan");
		register.setUsername("charan");
		
	when(repo.save(register)).thenReturn(register);
		
		assertThrows(GlobalExceptionHandler.class, ()->repo.existsByUsername(register.getUsername()));
		
		
		
		
	}
	
	
	
	
	
	
	@Test
	public void testServ()
	{
		
		when(repo.save(register)).thenReturn(register);
		
		assertEquals(1, service.add(1, 1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
