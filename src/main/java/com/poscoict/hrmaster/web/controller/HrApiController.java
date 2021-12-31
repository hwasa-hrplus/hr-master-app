package com.poscoict.hrmaster.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		 System.out.println("select");
        return hrService.findById(id);
    }
	 
	// post for admin 
	 @PostMapping("/api/v1/hrfixed/admin")
	public Long save(@RequestBody HrFixedDto hrFixedDto){
		 System.out.println("save here");
	    return hrService.saveByAdmin(hrFixedDto);
	}
}
