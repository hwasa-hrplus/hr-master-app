package com.poscoict.hrmaster.web.dto;

//@경빈
// 불필요한 domain 데이터 import 삭제
import com.poscoict.hrmaster.domain.employee.Employee;
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
	
	public HrFileDto(Employee entity) {
		this.uuid = entity.getFilesId().getUuid();
		this.name = entity.getFilesId().getName();
		this.path = entity.getFilesId().getPath();
		

	}

	// post image
	public Files toEntity() {
		return Files.builder().uuid(uuid).name(name).path(path).build();
	}
}
