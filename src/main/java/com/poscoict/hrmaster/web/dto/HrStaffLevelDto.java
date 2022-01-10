package com.poscoict.hrmaster.web.dto;

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
public class HrStaffLevelDto {
	private String code;
	private String level;
	private String name;
	
	public HrStaffLevelDto(Employee entity) {
		this.code = entity.getStafflevel().getCode();
		this.level = entity.getStafflevel().getLevel();
		this.name = entity.getStafflevel().getName();
	}
}
