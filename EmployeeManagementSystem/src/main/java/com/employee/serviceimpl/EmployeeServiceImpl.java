package com.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.EmployeeAddress;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public String add(EmployeeModel model) {
		repo.save(model);
		return "Employee added successfully";
	}

	@Override
	public EmployeeModel update(EmployeeModel model, int id) {
		// TODO Auto-generated method stub
		EmployeeModel updatedmodel = repo.findById(id).get();
		updatedmodel.setFirstName(model.getFirstName());
		updatedmodel.setLastName(model.getLastName());
		updatedmodel.setEmailId(model.getEmailId());
		updatedmodel.setContactNumber(model.getContactNumber());
		return repo.save(updatedmodel);
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "deleted emplyoee";
	}
	@Override
	public EmployeeModel ViewEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<EmployeeModel> optionalEmployee = repo.findById( id);
		return optionalEmployee.get();
	}

	@Override
	public EmployeeModel validateUser(String emailId, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		 if (repo.existsByEmailId(emailId)) {
			 String pwd = repo.getPassword(emailId);
			 System.out.println(pwd);
			 if(pwd.equals(password)) {
				  return repo.validateUserCredentials(emailId, password);
			 }
			 else {
				 throw new UserNotFoundException("User Not Found..");
			 }
			 
		 }
	        
		 else {
			 throw new UserNotFoundException("User Not Found..");
		 }
            //			 return repo.validateUserCredentials(emailId, password);
		 
	        //	    return repo.validateUserCredentials(emailId, password);
	}

	

}
