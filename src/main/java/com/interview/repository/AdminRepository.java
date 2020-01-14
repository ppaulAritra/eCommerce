package com.interview.repository;

import org.springframework.data.repository.CrudRepository;

import com.interview.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {

	Admin findByUsername(String username);



}
