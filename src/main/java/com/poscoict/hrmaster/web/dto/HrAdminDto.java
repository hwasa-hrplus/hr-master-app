package com.poscoict.hrmaster.web.dto;

import java.util.Date;

//@경빈
// 불필요한 domain 데이터 import 삭제
import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.files.Files;
import com.poscoict.hrmaster.domain.jobcategory.JobCategory;
import com.poscoict.hrmaster.domain.workplace.WorkPlace;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

// @지수
public class HrAdminDto {

	private String email;
	private String filesId;
	private Long id;
	private String password;
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
	private Long bossId;
	private boolean workType;
	private String phone;
	private Date birthDate;
	private String address;
	private String addressCode;
	private String addressDetail;
	private String workPlaceName;

	public HrAdminDto(Employee entity) {
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
		this.bossId = entity.getBossId();
		this.workType = entity.isWorkType();
		this.phone = entity.getPhone();
		this.birthDate = entity.getBirthDate();
		this.address = entity.getAddress();
		this.addressCode = entity.getAddressCode();
		this.addressDetail = entity.getAddressDetail();
		this.workPlaceName = entity.getWorkPlaceName();
	}

	// post for admin
	public Employee toEntity() {
		return Employee.builder().email(email).filesId(filesId).id(id).korName(korName).engName(engName)
				.startDate(startDate).role(role).residentNum(residentNum).age(age).gender(gender).departmentName(departmentName)
				.staffLevelName(staffLevelName).jobCategoryName(jobCategoryName).password(password).bossId(bossId).workType(workType)
				.phone(phone).birthDate(birthDate).address(address).addressCode(addressCode).addressDetail(addressDetail).workPlaceName(workPlaceName).build();
	}
}
