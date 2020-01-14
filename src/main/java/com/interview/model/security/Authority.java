package com.interview.model.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	private final String aurhority;
	
	

	public Authority(String aurhority) {
		this.aurhority = aurhority;
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return aurhority;
	}

}
