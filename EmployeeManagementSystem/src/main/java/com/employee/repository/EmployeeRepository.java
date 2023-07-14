package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
	@Query("SELECT u FROM EmployeeModel u WHERE u.emailId = ?1 and u.password = ?2")
    public EmployeeModel validateUserCredentials(String emailId, String password);
	public boolean existsByEmailId(String emailId);
	@Query(" SELECT u.password FROM EmployeeModel u WHERE u.emailId= :emailId")
	public String getPassword(@Param("emailId") String emailId );
    
}