package com.interview;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.interview.model.Admin;
import com.interview.model.security.Role;
import com.interview.model.security.UserRoles;
import com.interview.service.UserService;
import com.interview.utility.SecurityUtility;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		admin.setEmail("admin@gmail.com");
		
		Role role = new Role();
		Set<UserRoles> userRoles = new HashSet<UserRoles>();
		
		role.setRole("ROLE_ADMIN");
		
		userRoles.add(new UserRoles(role, admin));
		
		userService.createAdmin(admin, userRoles);
		
		
		
	}

}
