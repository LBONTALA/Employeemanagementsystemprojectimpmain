package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Integer>{
	@Query("select ad from EmployeeAddress ad Where empmodel_id= :id ")
    public EmployeeAddress getAddress(@Param ("id") Integer id);
}
