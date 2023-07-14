package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeModel;
import com.employee.model.EmployeeAddress;
import com.employee.model.LoginReq;
import com.employee.service.EmployeeService;
import com.employee.serviceimpl.UserNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/all")
	public List<EmployeeModel> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody EmployeeModel model) {
		service.add(model);
		return "Success !!!";

	}

	@PutMapping("/update/{id}")
	public EmployeeModel update(@RequestBody EmployeeModel model, @PathVariable int id) {
		return service.update(model, id);

	}
	


	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}

//	@PostMapping("/login")
//	public EmployeeModel validate(@PathVariable String emailId, @PathVariable String password) {
//		EmployeeModel user = service.validateUser(emailId, password));
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
	@PostMapping("/login")
	public  String validate(@RequestBody LoginReq loginReq) throws UserNotFoundException {
		EmployeeModel user = service.validateUser(loginReq.getEmailId(),loginReq.getPassword());
		return "login Successful";
	}
	@GetMapping("/view/{id}")
	public Optional<EmployeeModel> getAddressbyId(@PathVariable int id) {
		return Optional.of(service.ViewEmployee(id)) ;
		
	}

	
		
}
