package com.interview.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.interview.model.Admin;
import com.interview.repository.AdminRepository;

@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Admin admin=adminRepository.findByUsername(username);
		if (admin == null) {
			throw new UsernameNotFoundException("username not found");
		}
		return admin;
	}

}
