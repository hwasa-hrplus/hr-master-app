package com.poscoict.hrmaster.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeBossResponseDto {
	private Long id;	
	private Long bid;
	
	public EmployeeBossResponseDto(Long id, Long bid) {
		this.id = id;
		this.bid = bid;
	}	
	
}
