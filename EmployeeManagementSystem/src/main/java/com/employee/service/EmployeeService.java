package com.employee.service;

import java.security.PublicKey;
import java.util.List;

import com.employee.model.EmployeeModel;
import com.employee.serviceimpl.UserNotFoundException;

public interface EmployeeService {

	public String add(EmployeeModel model);

	EmployeeModel update(EmployeeModel model, int id);

	List<EmployeeModel> getAllEmployees();
	
	String delete(int id);
	public  EmployeeModel  ViewEmployee(int id);
	public EmployeeModel validateUser(String emailId, String password) throws UserNotFoundException;
	
}
