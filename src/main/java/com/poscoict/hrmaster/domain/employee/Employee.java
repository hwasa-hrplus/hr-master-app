package com.poscoict.hrmaster.domain.employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.poscoict.hrmaster.domain.department.Department;
import com.poscoict.hrmaster.domain.files.Files;
import com.poscoict.hrmaster.domain.jobcategory.JobCategory;
import com.poscoict.hrmaster.domain.project.Project;
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

	private static final long serialVersionUID = 1L;

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
	private Department department;

	@ManyToOne
	@JoinColumn(name = "staff_level_code")
	private StaffLevel stafflevel;

	@ManyToOne
	@JoinColumn(name = "job_category_code")
	private JobCategory jobCategory;

	@ManyToOne
	@JoinColumn(name = "project_code")
	private Project project;

	// @경빈
	// bossId 데이터 타입 String에서 Long으로 변경

	@Column(name = "boss_id")
	private Long bossId;

	@ManyToOne
	@JoinColumn(name = "boss_id", referencedColumnName = "boss_id", insertable = false, updatable = false)
	private Employee employeeId;

	@ManyToOne
	@JoinColumn(name = "workplace_code")
	private WorkPlace workPlace;

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

	@Builder

	public Employee(Long id, String email, String password, String role, Files filesId, Department department,
			StaffLevel stafflevel, JobCategory jobCategory, Long bossId, Employee employeeId, WorkPlace workPlace,
			String korName, String engName, Date startDate, String residentNum, int age, String gender,
			boolean workType, String phone, Date birthDate, String address, Project project) {

		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.filesId = filesId;
		this.department = department;
		this.stafflevel = stafflevel;
		this.jobCategory = jobCategory;
		this.bossId = bossId;
		this.employeeId = employeeId;
		this.workPlace = workPlace;
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
		this.project = project;
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
		this.filesId = (Files) employeeInfo.get("filesId");
		this.department = (Department) employeeInfo.get("department");
		this.stafflevel = (StaffLevel) employeeInfo.get("stafflevel");
		this.jobCategory = (JobCategory) employeeInfo.get("jobCategory");
		this.korName = (String) employeeInfo.get("korName");
		this.engName = (String) employeeInfo.get("engName");
		this.startDate = (Date) employeeInfo.get("startDate");
		this.residentNum = (String) employeeInfo.get("residentNum");
		this.age = (int) employeeInfo.get("age");
		this.gender = (String) employeeInfo.get("gender");

	}

	public void updateForEmployee(Map<String, Object> employeeInfo) {
		this.korName = (String) employeeInfo.get("korName");
		this.engName = (String) employeeInfo.get("engName");
		this.filesId = (Files) employeeInfo.get("filesId");

		System.out.println("entity: " + (String) employeeInfo.get("engName"));

	}
	
	//@수현
	// put method for employee(basic)
	public void updateForBasicEmployee(Map<String, Object> employeeInfo) {
		this.phone = (String) employeeInfo.get("phone");
		this.address = (String) employeeInfo.get("address");
		this.project = (Project) employeeInfo.get("project");

	}

}
