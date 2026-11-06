package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Department;

public interface DepartmentService {
	
	Department addDepartment(Department dept);
	Department updateDepartment(Department dept);
	List<Department> displayAllDepartments();
	String deleteDepartmentById(Long id);
	Department displayDepartmentById(Long id);
	List<Department> findByName(String name);
	List<Department> findByType(String type);
	
	
	


}
