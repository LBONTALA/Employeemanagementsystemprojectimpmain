package com.employee.service;

import java.util.Optional;

import com.employee.model.EmployeeAddress;
import com.employee.model.EmployeeModel;

public interface EmpAddressService {
//	public Optional<EmployeeAddress> getAddressbyId(int id);
	public EmployeeAddress getAddress(int id);
	public String add(EmployeeAddress empadd);
	public EmployeeAddress update(EmployeeAddress address,int id);
}
