package com.poscoict.hrmaster.domain.files;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "name")
	private String name;

	@Column(name = "ori_name")
	private String oriName;

	@Column(name = "path")
	private String path;

	@Builder
	public Files(long id, String name, String oriName, String path) {
		super();
		this.id = id;
		this.name = name;
		this.oriName = oriName;
		this.path = path;

	}
}
