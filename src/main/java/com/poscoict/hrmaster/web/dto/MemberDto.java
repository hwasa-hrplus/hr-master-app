package com.poscoict.hrmaster.web.dto;

import com.poscoict.hrmaster.domain.employee.Employee;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
	private String email;
	private String password;
	private String role;
	

	public Employee toEntity() {
		return Employee.builder().email(email).password(password).role(role).build();
	}

	@Builder
	public MemberDto(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
}
