package com.poscoict.hrmaster.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.hrmaster.service.HrService;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HrApiController {
	private final HrService hrService;

	@GetMapping("/api/v1/hrfixed/{id}")
	public HrFixedDto findById(@PathVariable Long id) {

		return hrService.findById(id);
	}
	
	//put method for master
	@PutMapping("/api/v1/hrfixed/admin/{id}")
	public Long updateByIdForAdmin(@PathVariable Long id, @RequestBody HrFixedDto hrFixedDto) {

		System.out.println("controller: "+hrFixedDto.getKorName());
		return hrService.updateByIdForAdmin(id, hrFixedDto);
	}
	
	//put method for employee
	@PutMapping("/api/v1/hrfixed/employee/{id}")
	public Long updateByIdForEmployee(@PathVariable Long id, @RequestBody HrFixedDto hrFixedDto) {

		System.out.println("controller: "+hrFixedDto.getKorName());
		return hrService.updateByIdForEmployee(id, hrFixedDto);
	}
}
