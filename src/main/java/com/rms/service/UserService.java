package com.rms.service;

import java.util.List;

import com.rms.model.User;

public interface UserService {

	User saveUser(User user);
	User editUser(User user);
	
	User getByEmpId(String empId);
	List<User> getAllEmp();

}
