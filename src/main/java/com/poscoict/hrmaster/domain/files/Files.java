package com.poscoict.hrmaster.domain.files;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
		
	@Column(name = "uuid")
	private String uuid;
	
	@Column(name = "name")
	private String name;

	@Column(name = "path")
	private String path;

	@Builder
	public Files(long id, String uuid, String name, String path) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.path = path;

	}
}
