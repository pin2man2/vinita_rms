package com.rms.service;

import java.util.Date;
import java.util.List;

import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.Repositories.UserRepository;
import com.rms.model.Project;
import com.rms.model.User;
import com.rms.util.RandomNumberGenerator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		// user.setEmpId(RandomNumberGenerator.getRandom4digit().toString());
		// check the user is exit or not
		List<User> fetchuser = repository.findByEmpIdAndFirstNameAndLastName(user.getEmpId(), user.getFirstName(),
				user.getLastName());

		if (fetchuser.size() == 0) {
			user.setIsActive(1);// is_active
			return repository.save(user);
		} else {
			return null;
		}

	}

	@Override
	public User getByEmpId(String empId) {
		System.out.println("Inside getByEmpId() service start");
		User user = null;
		try {
			user = repository.getByEmpId(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Inside getByEmpId() service end");
		return user;
	}
	@Override
	public List<User> getAllEmp() {
		System.out.println("Inside getAllEmp() service start");
		List<User> userLst = null;
		//List<User> userLstRes = null;
		try {
			userLst = repository.findAll();
			Date currentDt = new Date();
			
			for (User user : userLst) {

				for (Project p : user.getProjectList()) {

					if (currentDt.after(p.getEndDate())) {
						user.setRolledOff(true);
					}

				}

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Inside getAllEmp() service end");
		return userLst;
	}

	@Override
	public User editUser(User user) {

		// fetch the empId
		String id = user.getEmpId();
		 User fetchuser = null;
		try {
		 fetchuser = repository.getByEmpId(id);
		} catch (Exception e) {
		     e.printStackTrace();
		}

		if(fetchuser !=null) {
		
			//first name
			if(user.getFirstName() !=null)
				fetchuser.setFirstName(user.getFirstName());
			//last name
			if(user.getLastName() !=null)
				fetchuser.setLastName(user.getLastName());
			//mobile number
			if(user.getMobile() !=null)
				fetchuser.setMobile(user.getMobile());
			//email id
			if(user.getEmail() !=null)
				fetchuser.setEmail(user.getEmail());
			//grade
			if(user.getGrade() !=null)
				fetchuser.setGrade(user.getGrade());
			//rolled off
				fetchuser.setRolledOff(user.isRolledOff());
			// project edit
			if (user.getProjectList().size() > 0) {
				for (Project action : user.getProjectList()) {
					for (Project p : fetchuser.getProjectList()) {
						if (action.getProjectName() != null)
							p.setProjectName(action.getProjectName());
						if (action.getStartDate() != null)
							p.setStartDate(action.getStartDate());
						if (action.getEndDate() != null)
							p.setEndDate(action.getEndDate());
						if (action.getTechnologies() != null)
							p.setTechnologies(action.getTechnologies());
					}

				}

			}//if-end
			
		return repository.save(fetchuser);
		}// outer if-end
		else 
			return null;
	}

}
