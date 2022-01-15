package com.poscoict.hrmaster.domain.employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@DynamicUpdate
@Table(name = "employee")
public class Employee implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "files_id")
	private String filesId;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "staff_level_name")
	private String staffLevelName;

	@Column(name = "job_category_name")
	private String jobCategoryName;

	// @경빈
	// bossId 데이터 타입 String에서 Long으로 변경
	@Column(name = "boss_id")
	private Long bossId;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "boss_id", referencedColumnName = "boss_id", insertable = false, updatable = false)
	private Employee employeeId;

	@Column(name = "workplace_name")
	private String workPlaceName;

	@Column(name = "kor_name")
	private String korName;

	@Column(name = "eng_name")
	private String engName;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "resident_num")
	private String residentNum;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "work_type") // 휴직자 or 근무자
	private boolean workType;

	@Column(name = "phone")
	private String phone;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "address")
	private String address;
	
	@Column(name = "detail_address")
	private String addressDetail;
	
	@Column(name = "address_code")
	private String addressCode;

	@Builder
	public Employee(Long id, String email, String password, String role,  String departmentName,
			String staffLevelName, String jobCategoryName, Long bossId, String workPlaceName,
			String korName, String engName, Date startDate, String residentNum, int age, String gender,
			boolean workType, String phone, Date birthDate, String address,  String addressDetail, String filesId
			, String addressCode) {

		super();
		this.id = id;
		this.email = email;	
		this.password = password;
		this.role = role;
		this.filesId = filesId;
		this.departmentName = departmentName;
		this.staffLevelName = staffLevelName;
		this.jobCategoryName = jobCategoryName;
		this.bossId = bossId;
		this.workPlaceName = workPlaceName;
		this.korName = korName;
		this.engName = engName;
		this.startDate = startDate;
		this.residentNum = residentNum;
		this.age = age;
		this.gender = gender;
		this.workType = workType;
		this.phone = phone;
		this.birthDate = birthDate;
		this.address = address;
		this.addressDetail = addressDetail;
		this.addressCode = addressCode;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> roles = new HashSet<>();
		for (String r : role.split(",")) {
			roles.add(new SimpleGrantedAuthority(r));
		}
		return roles;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	// update logic
	public void updateForAdmin(Map<String, Object> employeeInfo) {
	
		this.id = (Long) employeeInfo.get("id");
		this.email = (String) employeeInfo.get("email");
		this.role = (String) employeeInfo.get("role");
		this.filesId = (String) employeeInfo.get("filesId");
		this.departmentName = (String) employeeInfo.get("departmentName");
		this.staffLevelName = (String) employeeInfo.get("staffLevelName");
		this.jobCategoryName = (String) employeeInfo.get("jobCategoryName");
		this.korName = (String) employeeInfo.get("korName");
		this.engName = (String) employeeInfo.get("engName");
		this.startDate = (Date) employeeInfo.get("startDate");
		this.residentNum = (String) employeeInfo.get("residentNum");
		this.age = (int) employeeInfo.get("age");
		this.gender = (String) employeeInfo.get("gender");	
		this.password = (String) employeeInfo.get("password");
		this.bossId = (Long) employeeInfo.get("bossId");
		this.workPlaceName = (String) employeeInfo.get("workPlaceName");
		this.workType = (boolean) employeeInfo.get("workType");
		this.phone = (String) employeeInfo.get("phone");
		this.birthDate = (Date) employeeInfo.get("birthDate");
		this.address = (String) employeeInfo.get("address");
		this.addressDetail = (String) employeeInfo.get("addressDetail");
		this.addressCode = (String) employeeInfo.get("addressCode");
		
		System.out.println((String) employeeInfo.get("workPlaceName"));
		System.out.println(this.workPlaceName);

	}

	public void updateForEmployee(Map<String, Object> employeeInfo) {
		this.korName = (String) employeeInfo.get("korName");
		this.engName = (String) employeeInfo.get("engName");
		this.filesId = (String) employeeInfo.get("filesId");

		System.out.println("entity: " + (String) employeeInfo.get("engName"));

	}
	
	//@수현
	// put method for employee(basic)
	public void updateForBasicEmployee(Map<String, Object> employeeInfo) {
		this.phone = (String) employeeInfo.get("phone");
		this.address = (String) employeeInfo.get("address");
		this.addressDetail = (String) employeeInfo.get("addressDetail");
		this.addressCode = (String) employeeInfo.get("addressCode");

	}

}
