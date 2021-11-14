package com.dailycodebuffer.SpringBoot.Tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//to make this class as an entity so that it can interact with our datbase using jpa add @entity annotation
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
	
	//database needs a primary key
	@Id
	
	//primary  key generation type
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long departmentId;
	@NotBlank(message = "please add dept name")
	@Length(max = 5,min = 1)
	@Size(max = 10,min = 0)
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	
	
}