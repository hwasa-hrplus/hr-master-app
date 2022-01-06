package com.poscoict.hrmaster.web.dto;

import java.util.Date;

//@경빈
// 불필요한 domain 데이터 import 삭제
import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.workplace.WorkPlace;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
// @경빈: 2021-12-31
// 인사 기본 DTO 설계
public class HrBasicDto {
	private Long bossId;
	private boolean workType;
	private String phone;
	private Date birthDate;
	private String address;
	private String detail_address;
	private String address_code;;
	private WorkPlace workPlace;
	

	public HrBasicDto(Employee entity) {
		this.bossId = entity.getBossId();
		this.workType = entity.isWorkType();
		this.phone = entity.getPhone();
		this.birthDate = entity.getBirthDate();
		this.address = entity.getAddress();
		this.detail_address = entity.getDetail_address();
		this.workPlace = entity.getWorkPlace();
	}
}
