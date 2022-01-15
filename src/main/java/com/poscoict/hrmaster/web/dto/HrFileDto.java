package com.poscoict.hrmaster.web.dto;

import com.poscoict.hrmaster.domain.files.Files;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

// @지수
public class HrFileDto {
	private String name;
	private String path;
	private String uuid;
	private Long userId;
	
	public HrFileDto(Files files) {
		this.userId = files.getUserId();
		this.uuid = files.getUuid();
		this.name = files.getName();
		this.path = files.getPath();
		

	}

	// post image
	public Files toEntity() {
		return Files.builder().userId(userId).uuid(uuid).name(name).path(path).build();
	}
}
