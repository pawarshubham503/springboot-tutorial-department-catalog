package com.dailycodebuffer.SpringBoot.Tutorial.service;

import java.util.List;

import com.dailycodebuffer.SpringBoot.Tutorial.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);


}
