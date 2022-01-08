package com.poscoict.hrmaster.web.controller;

import java.util.List;

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

@RequiredArgsConstructor
@RestController
public class HrApiController {

	private final HrFixedService hrFixedService;
	private final HrBasicService hrBasicService;
	private final HrAdminService hrAdminService;

	// @지수
	// put method for master
	@PutMapping("/hrfixed/admin/{id}")
	public Long updateByIdForAdmin(@PathVariable Long id, @RequestBody HrFixedDto hrFixedDto) {

		System.out.println("controller: " + hrFixedDto.getKorName());
		return hrFixedService.updateByIdForAdmin(id, hrFixedDto);
	}

	// @지수
	// put method for employee
	@PutMapping("/hrfixed/employee/{id}")
	public Long updateByIdForEmployee(@PathVariable Long id, @RequestBody HrFixedDto hrFixedDto) {

		System.out.println("controller: " + hrFixedDto.getKorName());
		return hrFixedService.updateByIdForEmployee(id, hrFixedDto);
	}

	// @윤욱
	// delete method for employee
	@DeleteMapping("/hrfixed/{id}")
	public Long delete(@PathVariable Long id) {
		hrFixedService.delete(id);
		return id;
	}

	// @경빈
	// 메서드 이름 변경: findById -> hrFixedById
	@GetMapping("/hrfixed/{id}")
	public HrFixedDto hrFixedfindById(@PathVariable Long id) {
		return hrFixedService.findById(id);
	}

	// @경빈
	// 인사기본 조회 추가
	@GetMapping("/hrbasic/{id}")
	public HrBasicDto hrBasicfindById(@PathVariable Long id) {
		return hrBasicService.findById(id);
	}

	// @수현
	// put method for employee(basic)
	@PutMapping("/hrbasic/employee/{id}")
	public Long updateByIdForBasicEmployee(@PathVariable Long id, @RequestBody HrBasicDto hrBasicDto) {
		return hrBasicService.updateByIdForEmployee(id, hrBasicDto);

	}

	// @수현
	// 회원 전체 리스트 조회
	@GetMapping("/hradmin/admin/list")
	public List<Employee> hrBasicfindAll() {
		return hrAdminService.findByAll();
	}

	// @지수
	// 어드민 사원디테일 조회
	@GetMapping("/hradmin/admin/list/{id}")
	public List<Employee> hrAdminfindDetail(@PathVariable Long id) {
		return hrAdminService.findbyIdForDetail(id);
	}

	// @지수
	// 어드민 사원디테일 추가
	@PostMapping("/hradmin/admin")
	public Long save(@RequestBody HrAdminDto hrAdminDto) {
		return hrAdminService.saveByAdmin(hrAdminDto);
	}

}
