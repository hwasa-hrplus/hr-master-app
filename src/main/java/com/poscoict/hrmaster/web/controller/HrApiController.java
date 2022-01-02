package com.poscoict.hrmaster.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.hrmaster.service.HrFixedService;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import com.poscoict.hrmaster.service.HrBasicService;
import com.poscoict.hrmaster.web.dto.HrBasicDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HrApiController {
	private final HrFixedService hrFixedService ;
	private final HrBasicService hrBasicService ;
	
	// @경빈
	// 메서드 이름 변경: findById -> hrFixedById
	@GetMapping("/api/v1/hrfixed/{id}")
	public HrFixedDto hrFixedfindById(@PathVariable Long id){
		return hrFixedService.findById(id);
	}
	
	// @경빈
	// 인사기본 조회 추가
	@GetMapping("/api/v1/hrbasic/{id}")
	public HrBasicDto hrBasicfindById(@PathVariable Long id){
		return hrBasicService.findById(id);
	}
	
}
