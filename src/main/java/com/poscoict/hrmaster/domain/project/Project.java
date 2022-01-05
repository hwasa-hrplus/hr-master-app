package com.poscoict.hrmaster.domain.project;

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
@Table(name = "Project")
public class Project {
	@Id
	@Column(name = "code", nullable = false)	
	private String code;
		
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost_center")
	private String costCenter;

	@Builder
	public Project(String code, String name, String costCenter) {
		super();
		this.code = code;
		this.name = name;
		this.costCenter= costCenter;
	}
}
