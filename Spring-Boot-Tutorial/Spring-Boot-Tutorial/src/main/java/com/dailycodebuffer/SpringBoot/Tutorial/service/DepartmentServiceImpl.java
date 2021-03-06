/**
 * 
 */
package com.dailycodebuffer.SpringBoot.Tutorial.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.SpringBoot.Tutorial.entity.Department;
import com.dailycodebuffer.SpringBoot.Tutorial.repository.DepartmentRepository;

/**
 * @author ASUS
 *
 */

//to know this class is service annotate with @service
@Service
public class DepartmentServiceImpl implements DepartmentService {
@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		return	departmentRepository.save(department);
		
	}
	@Override
	public List<Department> fetchDepartmentList() {
		return	departmentRepository.findAll();
		
	}
	@Override
	public Department fetchDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
		
	} 
	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}
	@Override 
	public Department updateDepartment(Long departmentId, Department department) {
	Department depDB= departmentRepository.findById(departmentId).get();
	if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
		depDB.setDepartmentName(department.getDepartmentName());
	}
	if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
		depDB.setDepartmentCode (department.getDepartmentCode());
	}
	if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
		depDB.setDepartmentAddress(department.getDepartmentAddress());
	}
	return departmentRepository.save(depDB);
	}
	@Override
	public Department fetchDepartmentByName(String departmentName) {
		departmentRepository.findByDepartmentName(departmentName);
		return null;
	}
	
	
	

}
