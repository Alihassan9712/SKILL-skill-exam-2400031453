package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Department;
import com.klef.soa.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department addDepartment(Department dept) {
		return repo.save(dept);
	}

	@Override
	public Department updateDepartment(Department dept) {
Optional<Department> optional = repo.findById(dept.getId());
		
		if(optional.isPresent())
		{
			Department department = optional.get();
			
			department.setName(dept.getName());
			department.setId(dept.getId());
			department.setType(dept.getType());
			department.setStatus(dept.getStatus());
			department.setLocation(dept.getLocation());
			
			
			return repo.save(department);
		}  
		else
		{
			return null;
		}
	}

	@Override
	public List<Department> displayAllDepartments() {
		return repo.findAll();
	}

	@Override
	public Department displayDepartmentById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteDepartmentById(Long id) {
		
		boolean flag  = repo.existsById(id);
		if(flag)
		{
			repo.deleteById(id);
			return "Department Deleted Successfully";
		}
		else
		{
		 return "Department ID Not Found";
		}
		
	}
	
	@Override
	public List<Department> findByName(String Name) {
		return repo.findByName(Name);
	}
	
	@Override
	public List<Department> findByType(String Name) {
		return repo.findByType(Name);
	}
	
	
	
	
	
	
		
}
