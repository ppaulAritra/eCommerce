package com.interview.repository;

import org.springframework.data.repository.CrudRepository;

import com.interview.model.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	

}
