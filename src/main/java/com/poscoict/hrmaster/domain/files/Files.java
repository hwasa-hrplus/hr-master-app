package com.poscoict.hrmaster.domain.files;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.poscoict.hrmaster.domain.employee.Employee;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "files")
public class Files {

	@Column(name = "uuid")
	private String uuid;
	
	@Id
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "name")
	private String name;

	@Column(name = "path")
	private String path;

	@Builder
	public Files(String uuid, Long userId, String name, String path) {
		super();
		
		this.userId = userId;
		this.uuid = uuid;
		this.name = name;
		this.path = path;

	}

	public void updateFile(Long userId, String uuid, String name, String path) {
		this.userId = userId;
		this.uuid = uuid;
		this.name = name;
		this.path = path;
		
	}
}
