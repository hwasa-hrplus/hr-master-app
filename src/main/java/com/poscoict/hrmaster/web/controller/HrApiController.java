package com.poscoict.hrmaster.web.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.service.HrAdminService;
import com.poscoict.hrmaster.service.HrBasicService;
import com.poscoict.hrmaster.service.HrFixedService;
import com.poscoict.hrmaster.web.dto.HrAdminDto;
import com.poscoict.hrmaster.web.dto.HrBasicDto;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
public class HrApiController {
	private final HrFixedService hrFixedService;
	private final HrBasicService hrBasicService;
	private final HrAdminService hrAdminService;
	
	// @지수
	// update method for employee fixed data
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PutMapping("/hrfixed/{id}")
	public Long updateByIdForEmployee(@PathVariable Long id, @RequestBody HrFixedDto hrFixedDto) {

		System.out.println("controller: " + hrFixedDto.getKorName());
		return hrFixedService.updateByIdForEmployee(id, hrFixedDto);
	}

	// @윤욱
	// delete method for employee
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public Long delete(@PathVariable Long id) {
		hrFixedService.delete(id);
		return id;
	}

	// @경빈
	// 메서드 이름 변경: findById -> hrFixedById
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/hrfixed/{id}")
	public HrFixedDto hrFixedfindById(@PathVariable Long id) {
		return hrFixedService.findById(id);
	}

	// @경빈
	// 인사기본 조회 추가
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/hrbasic/{id}")
	public HrBasicDto hrBasicfindById(@PathVariable Long id) {
		return hrBasicService.findById(id);
	}

	// @수현
	// put method for employee(basic)
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PutMapping("/hrbasic/{id}")
	public Long updateByIdForBasicEmployee(@PathVariable Long id, @RequestBody HrBasicDto hrBasicDto) {
		return hrBasicService.updateByIdForEmployee(id, hrBasicDto);

	}

	// @수현
	// 회원 전체 리스트 조회
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/hradmin/list")
	public List<Employee> hrBasicfindAll() {
		return hrAdminService.findByAll();
	}

	// @지수
	// 어드민 사원디테일 조회
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/hradmin/{id}")
	public List<Employee> hrAdminfindDetail(@PathVariable Long id) {
		return hrAdminService.findbyIdForDetail(id);
	}

	// @지수
	// 어드민 사원디테일 추가
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/hradmin")
	public Long save(@RequestBody HrAdminDto hrAdminDto) {
		return hrAdminService.saveByAdmin(hrAdminDto);
	}
}
