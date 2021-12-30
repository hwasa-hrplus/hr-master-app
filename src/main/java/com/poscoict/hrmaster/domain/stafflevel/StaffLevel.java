package com.poscoict.hrmaster.domain.stafflevel;

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
@Table(name = "staff_level")
public class StaffLevel {
	@Id
	@Column(name = "code", nullable = false)	
	private String code;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "name")
	private String name;

	@Builder
	public StaffLevel(String code, String level, String name) {
		super();
		this.code = code;
		this.level = level;
		this.name = name;
	}
}