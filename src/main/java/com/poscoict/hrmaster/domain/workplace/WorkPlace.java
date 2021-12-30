package com.poscoict.hrmaster.domain.workplace;

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
@Table(name = "workplace")
public class WorkPlace {
	@Id
	@Column(name = "code", nullable = false)	
	private String code;
		
	@Column(name = "name")
	private String name;
	
	@Column(name = "workplace_grade")
	private String workplaceGrade;

	@Builder
	public WorkPlace(String code, String name, String workplaceGrade) {
		super();
		this.code = code;
		this.name = name;
		this.workplaceGrade= workplaceGrade;
	}	
}
