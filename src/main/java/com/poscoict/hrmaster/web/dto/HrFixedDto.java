package com.poscoict.hrmaster.web.dto;

import java.util.Date;

import com.poscoict.hrmaster.domain.department.Department;
import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.jobcategory.JobCategory;
import com.poscoict.hrmaster.domain.stafflevel.StaffLevel;

import lombok.Builder;
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
	private Long filesId;
	private Long id;
	private String korName;
	private String engName;
	private Date startDate;
	private String role;
	private String residentNum;
	private int age;
	private String gender;
	private Department departmentCode;
	private StaffLevel stafflevelCode;
	private JobCategory jobCategoryCode;

	public HrFixedDto(Employee entity) {
		this.email = entity.getEmail();
		this.id = entity.getId();
		this.korName = entity.getKorName();
		this.engName = entity.getEngName();
		this.startDate = entity.getStartDate();
		this.role = entity.getRole();
		this.residentNum = entity.getResidentNum();
		this.age = entity.getAge();
		this.gender = entity.getGender();
		this.departmentCode = entity.getDepartmentCode();
		this.stafflevelCode = entity.getStafflevelCode();
		this.jobCategoryCode = entity.getJobCategoryCode();
	}
}
