package com.cybage.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	String authority;

	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		
		return authority;
	}

}
