package com.poscoict.hrmaster.domain.employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.poscoict.hrmaster.domain.department.Department;
import com.poscoict.hrmaster.domain.files.Files;
import com.poscoict.hrmaster.domain.jobcategory.JobCategory;
import com.poscoict.hrmaster.domain.stafflevel.StaffLevel;
import com.poscoict.hrmaster.domain.workplace.WorkPlace;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "employee")
public class Employee implements UserDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role")
	private String role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "files_id", referencedColumnName = "id")
	private Files filesId;

	@ManyToOne
	@JoinColumn(name = "department_code")
	private Department departmentCode;

	@ManyToOne
	@JoinColumn(name = "staff_level_code")
	private StaffLevel stafflevelCode;

	@ManyToOne
	@JoinColumn(name = "job_category_code")
	private JobCategory jobCategoryCode;
	
	// @경빈
	// bossId 데이터 타입 String에서 Long으로 변경
	@Column(name = "boss_id")
	private Long bossId;

	@ManyToOne
	@JoinColumn(name = "boss_id", referencedColumnName = "boss_id", insertable = false, updatable = false)
	private Employee employeeId;

	@ManyToOne
	@JoinColumn(name = "workplace_code")
	private WorkPlace workPlaceCode;

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

	@Column(name = "project_code")
	private String projectCode;

	@Builder
	public Employee(Long id, String email, String password, String role, Files filesId, Department departmentCode,
			StaffLevel stafflevelCode, JobCategory jobCategoryCode, Long bossId, Employee employeeId,
			WorkPlace workPlaceCode, String korName, String engName, Date startDate, String residentNum, int age,
			String gender, boolean workType, String phone, Date birthDate, String address, String projectCode) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.filesId = filesId;
		this.departmentCode = departmentCode;
		this.stafflevelCode = stafflevelCode;
		this.jobCategoryCode = jobCategoryCode;
		this.bossId = bossId;
		this.employeeId = employeeId;
		this.workPlaceCode = workPlaceCode;
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
		this.projectCode = projectCode;
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

	
}
