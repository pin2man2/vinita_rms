package com.rms.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayway.jsonpath.Option;
import com.rms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User getByEmpId(String empId);
	
	@Query(value="select * from USER u where u.EMP_ID=?1 OR (u.FIRST_NAME=?2 and u.LAST_NAME=?3)",nativeQuery=true)
	List<User> findByEmpIdAndFirstNameAndLastName(String empid,String fn,String ln);
	
	

}
