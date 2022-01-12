package com.poscoict.hrmaster.web.dto;

import java.util.Date;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.files.Files;
import com.poscoict.hrmaster.domain.jobcategory.JobCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HrFixedDto {

	private String email;
	private String filesId;
	private Long id;
	
	// @경빈
	// 파일ID 타입 변경: Long -> Files 클래스
	private String korName;
	private String engName;
	private Date startDate;
	private String role;
	private String residentNum;
	private int age;
	private String gender;
	private String departmentName;
	private String staffLevelName;
	private String jobCategoryName;
	private String password;

	public HrFixedDto(Employee entity) {
		this.filesId = entity.getFilesId();
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.korName = entity.getKorName();
		this.engName = entity.getEngName();
		this.startDate = entity.getStartDate();
		this.role = entity.getRole();
		this.residentNum = entity.getResidentNum();
		this.age = entity.getAge();
		this.gender = entity.getGender();
		this.departmentName = entity.getDepartmentName();
		this.staffLevelName = entity.getStaffLevelName();
		this.jobCategoryName = entity.getJobCategoryName();
		this.password = entity.getPassword();

	}

	// post for admin
	public Employee toEntity() {
		return Employee.builder().email(email).filesId(filesId).id(id).korName(korName).engName(engName)
				.startDate(startDate).role(role).residentNum(residentNum).age(age).gender(gender).departmentName(departmentName)
				.staffLevelName(staffLevelName).jobCategoryName(jobCategoryName).filesId(filesId)

				.password(password).build();
	}
}
