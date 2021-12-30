package com.poscoict.hrmaster.domain.department;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name = "code", nullable = false)	
	private String code;
		
	@Column(name = "name")
	private String name;

	@Builder
	public Department(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}	
}
