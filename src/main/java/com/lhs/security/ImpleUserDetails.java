package com.lhs.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lhs.entity.RegistrationEntity;

public class ImpleUserDetails implements UserDetails {

	RegistrationEntity reg;

	public ImpleUserDetails(RegistrationEntity reg) {
		super();
		this.reg = reg;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Collections.singleton(new SimpleGrantedAuthority("USER"));

	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return reg.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return reg.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
