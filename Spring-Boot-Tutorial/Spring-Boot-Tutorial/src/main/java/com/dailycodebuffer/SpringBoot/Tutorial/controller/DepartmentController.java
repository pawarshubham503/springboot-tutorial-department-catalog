package com.dailycodebuffer.SpringBoot.Tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.SpringBoot.Tutorial.entity.Department;
import com.dailycodebuffer.SpringBoot.Tutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	
	//to save data to db
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department)
	{
		 logger.info("Inside saveDepartment of DepartmentController");
	return departmentService.saveDepartment(department);
	}
	
	
	//to fetch all records from db
	@GetMapping("/departments")
	public List<Department> fetchDepartment(){
		 logger.info("Inside fetchDepartment of DepartmentController"+departmentService.fetchDepartmentList());

		return departmentService.fetchDepartmentList();
	}
	

	//to fetch records by id we must use pathvariable to provide id 
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
	return departmentService.fetchDepartmentById(departmentId);	
	}
	
	//to delete records by id we must use pathvariable to provide id 

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
	departmentService.deleteDepartmentById(departmentId);
		return	"department deleted successfuly";
	}
	
	
	//to update database record use @put mapping
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department,@PathVariable("id") Long departmentId) {
	return	departmentService.updateDepartment(departmentId,department);
	}
	
	//to fetch department by name
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
	return departmentService.fetchDepartmentByName(departmentName)	;
	}
	
	
	
	
}








