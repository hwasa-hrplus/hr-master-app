package com.poscoict.hrmaster.web.dto;

import com.poscoict.hrmaster.domain.department.Department;
import com.poscoict.hrmaster.domain.employee.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

// @지수
public class HrDepartmentDto {
	private String code;
	private String name;
	
	public HrDepartmentDto(Department department) {
		this.code = department.getCode();
		this.name = department.getName();
	}
}
