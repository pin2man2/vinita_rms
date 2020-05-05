package com.rms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rms.model.User;
import com.rms.service.UserService;

/**
 * @author Veenita
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public Map<Object, Object> saveUser(@RequestBody User user) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		User oldser = userService.saveUser(user);
		if (null != oldser) {
			map.put("Response", "200");
			map.put("Message", "User details added..");
			map.put("object", oldser);
		} else {
			map.put("Response", "400");
			map.put("Message", "User already exist");
		}
		return map;
	}
	
	@PutMapping("/editUser")
	public Map<Object, Object> editUser(@RequestBody User user) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		User oldser = userService.editUser(user);
		if (null != oldser) {
			map.put("Response", "200");
			map.put("Message", "User details modifed Succesfully..");
			map.put("object", oldser);
		} else {
			map.put("Response", "400");
			map.put("Message", "Empid not exist");
		}
		return map;
	}
	
	
	@GetMapping("/getByEmpId/{empid}")
	public Map<Object, Object>  getByEmpId(@PathVariable("empid") String empId){
		Map<Object, Object> map = new HashMap<Object, Object>();
		System.out.println("Inside getByEmpId() controller start"+empId);
		User user = null;
	
		try {
			user=userService.getByEmpId(empId);
			if (null != user) {
				map.put("Response", "200");
				map.put("Message", "User details are given below");
				map.put("object", user);
			} else {
				map.put("Response", "400");
				map.put("Message", "User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
		
	}

	//find ALL employee
	@GetMapping("/getAllEmp")
	public Map<Object, Object>  getAllEmp(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		System.out.println("Inside getAllEmp() controller start");
		List<User> userLst = null;
	
		try {
			userLst=userService.getAllEmp();
			if (null != userLst) {
				map.put("Response", "200");
				map.put("Message", "User details are given below");
				map.put("object", userLst);
			} else {
				map.put("Response", "400");
				map.put("Message", "Please try again!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
		
	}
	
	
	
	
	
	
}
