package com.poscoict.hrmaster.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.hrmaster.service.HrService;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HrApiController {
	private final HrService hrService ;
	
	 @GetMapping("/api/v1/hrfixed/{id}")
    public HrFixedDto findById(@PathVariable Long id){
		 
        return hrService.findById(id);
    }
}
