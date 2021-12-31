package com.poscoict.hrmaster.web.dto;

import java.util.Date;

import com.poscoict.hrmaster.domain.department.Department;
import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.files.Files;
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
	private Files filesId;
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
	
	private String password;

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
		
		this.password = entity.getPassword();
	}
	
	
	// post for admin 
	 public Employee toEntity(){
	        return Employee.builder()
	                .email(email)
	                .filesId(filesId)
	                .id(id)
	                .korName(korName)
	                .engName(engName)
	                .startDate(startDate)
	                .role(role)
	                .residentNum(residentNum)
	                .age(age)
	                .gender(gender)
	                .departmentCode(departmentCode)
	                .stafflevelCode(stafflevelCode)
	                .jobCategoryCode(jobCategoryCode)   
	                
	                .password(password)
	                .build();
	    }
}
