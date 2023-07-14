package com.employee.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeAddress;
import com.employee.model.EmployeeModel;
import com.employee.serviceimpl.EmployeeAddressImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmpAddressController {
	@Autowired
	EmployeeAddressImpl adimp;
	
//	@GetMapping("/getAddress/{id}")
//	public Optional<EmployeeAddress> getAddress(@PathVariable int id){
//		return adimp.getAddressbyId(id);
//		
//	}
	@GetMapping("/getAddr/{id}")
	public Optional<EmployeeAddress> getAddressbyId(@PathVariable int id) {
		
		return Optional.of(adimp.getAddress(id)) ;
		
	}
	@PostMapping("/addEmp")
	public String addEmp(@RequestBody EmployeeAddress empadd) {
		adimp.add(empadd);
		return "added successfully ";
}
	@PutMapping("/updateAd/{id}")
	public String update(@RequestBody EmployeeAddress address, @PathVariable int id) {
		adimp.update(address, id);
		return "successfully updated";

	}
}
