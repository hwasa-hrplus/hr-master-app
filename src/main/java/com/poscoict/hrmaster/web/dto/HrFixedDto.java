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

	private String filesId;
	private Long id;
	private String korName;
	private String engName;
	private Date startDate;
	private String staffLevelName;
	private String jobCategoryName;
	private String departmentName;
	private String role;
	private String residentNum;
	private int age;
	private String gender;
	
	
	public HrFixedDto(Employee entity) {
		super();
		this.filesId = entity.getFilesId();
		this.id = entity.getId();
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
	}

}
