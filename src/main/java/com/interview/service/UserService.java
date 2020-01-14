package com.interview.service;

import java.util.Set;

import com.interview.model.Admin;
import com.interview.model.security.UserRoles;

public interface UserService {

	Admin createAdmin(Admin admin, Set<UserRoles> userRoles);
	Admin save(Admin admin);

}
