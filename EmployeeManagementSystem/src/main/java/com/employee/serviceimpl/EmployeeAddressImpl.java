package com.employee.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.model.EmployeeAddress;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeAddressRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmpAddressService;
import com.employee.service.EmployeeService;

@Service
public class EmployeeAddressImpl implements EmpAddressService{
	@Autowired 
	EmployeeAddressRepository adrepo;

//	@Override
//	public Optional<EmployeeAddress> getAddressbyId(int id) {
//		Optional <EmployeeAddress> ea = adrepo.findById(id);
//		return ea;
//	}

	@Override
	public EmployeeAddress getAddress(int id) {
		
		return adrepo.getAddress(id) ;
	}

	@Override
	public String add(EmployeeAddress empadd) {
		adrepo.save(empadd);
		return "Employee added successfully";
	}

	@Override
	public EmployeeAddress update(EmployeeAddress address, int id) {
		EmployeeAddress updatedAddress = adrepo.findById(id).get();
		updatedAddress.setPincode(address.getPincode());
		updatedAddress.setCity(address.getCity());
		updatedAddress.setState(address.getState());
		updatedAddress.setCountry(address.getCountry());
		return adrepo.save(updatedAddress);
	}
		
		 
	}


