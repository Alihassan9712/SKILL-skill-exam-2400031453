package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Department;
import com.klef.soa.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping("/")
	public String demo() {
		return "Department Project";
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department dept){
		Department department = service.addDepartment(dept);
		return ResponseEntity.status(201).body(department);
	}
	
	@GetMapping("/displayall")
	public ResponseEntity<List<Department>> displayAllDepartments()
	{
		List<Department> depts = service.displayAllDepartments();
		return ResponseEntity.status(200).body(depts);
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> displayDepartmentById(@RequestParam Long id)
	{
		Department department = service.displayDepartmentById(id);

		if (department != null)
		{
			return ResponseEntity.status(200).body(department);
		}
		else
		{
			return ResponseEntity.status(404).body("Department ID Not Found");
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateDepartment(@RequestBody Department dept)
	{
		Department d = service.updateDepartment(dept);

		if (d != null)
		{
			return ResponseEntity.ok(d);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department ID Not Found");
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id)
	{
		String message = service.deleteDepartmentById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<?> displayDepartmentByName(@PathVariable String name) {
		List<Department> depts = service.findByName(name);

		if (depts != null)
		{
			return ResponseEntity.status(200).body(depts);
		}
		else
		{
			return ResponseEntity.status(404).body("Department Name Not Found");
		}
	}
	
	
	@GetMapping("/findbytype/{type}")
	public ResponseEntity<?> displayDepartmentByType(@PathVariable String type) {
		List<Department> depts = service.findByType(type);

		if (depts != null)
		{
			return ResponseEntity.status(200).body(depts);
		}
		else
		{
			return ResponseEntity.status(404).body("Department type Not Found");
		}
	}
	

}
