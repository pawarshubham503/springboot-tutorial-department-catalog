package com.dailycodebuffer.SpringBoot.Tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.SpringBoot.Tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	
	
	public Department findByDepartmentName(String departmentName);
}
