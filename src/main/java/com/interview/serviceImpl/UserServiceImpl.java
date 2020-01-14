package com.interview.serviceImpl;


import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.model.Admin;
import com.interview.model.security.UserRoles;
import com.interview.repository.AdminRepository;
import com.interview.repository.RoleRepository;
import com.interview.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	private static final Logger Logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	


	@Override
	public Admin createAdmin(Admin admin, Set<UserRoles> userRoles) {
		// TODO Auto-generated method stub
		
		Admin localAdmin = adminRepository.findByUsername(admin.getUsername());
		
		if (localAdmin != null) {
			Logger.info("admin is exist");
		}else {
			for (UserRoles userRoles2 : userRoles) {
				roleRepository.save(userRoles2.getRole());
			}
			admin.getUserRoles().addAll(userRoles);
			localAdmin = adminRepository.save(admin);
		}
		
		return localAdmin;
		
		
		
	}


	@Override
	public Admin save(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

}
