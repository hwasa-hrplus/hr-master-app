package com.poscoict.hrmaster.web.dto;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.stafflevel.StaffLevel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

// @지수
public class HrStaffLevelDto {
	private String code;
	private String level;
	private String name;
	
	public HrStaffLevelDto(StaffLevel staffLevel) {
		this.code = staffLevel.getCode();
		this.level = staffLevel.getLevel();
		this.name = staffLevel.getName();
	}
}
