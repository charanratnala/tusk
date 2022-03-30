package com.lhs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lhs.entity.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityHandler extends WebSecurityConfigurerAdapter {

	@Autowired
	ImplementationUserDetailsService serve;

	@Autowired
	JwtFilter filter;

//
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		
//		
//		List<UserDetails> us= new ArrayList<>();
//		us.add(User.withDefaultPasswordEncoder().username("charan").password("charan").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(us);
//		
//		
//		
//		
//	}

	@Bean
	public AuthenticationProvider auth() {

		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(serve);
		dao.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return dao;
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.csrf().disable().authorizeRequests().anyRequest().authenticated();

		http.csrf().disable()

				.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.httpBasic();
		http.formLogin();

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

//	}
//	
//	

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		// http.csrf().disable().authorizeRequests().antMatchers("/test").permitAll().antMatchers("/addreg").permitAll().anyRequest().authenticated();
//
//		http.csrf().disable().authorizeRequests().antMatchers("/login","/home","/addreg").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logg").permitAll();
//
//	}
//	
//	
//	
//	
//	@Bean
//	public AuthenticationProvider auth()
//	{
//		DaoAuthenticationProvider dao= new DaoAuthenticationProvider();
//		dao.setUserDetailsService(serve);
//		dao.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return dao;
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.userDetailsService(serve);
//
//	}

//	@Bean
//	public PasswordEncoder encode() {
//		return NoOpPasswordEncoder.getInstance();
//	}

	}
}
