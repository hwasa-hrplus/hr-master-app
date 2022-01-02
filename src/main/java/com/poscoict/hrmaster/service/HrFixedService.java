package com.poscoict.hrmaster.service;

import org.springframework.stereotype.Service;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.employee.EmployeeRepository;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //@Autowired 없이 생성자로 주입하는 방식
//final이 선언된 필드를 인자값으로 하는 생성자를 생성함
@Service

// @경빈
// 클래스 이름 변경: HrService -> HrFixedService
public class HrFixedService {
	private final EmployeeRepository employeeRepository;
	
	public HrFixedDto findById(Long id){
        Employee entity = employeeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 정보가 없습니다. id="+ id));
      
        return new HrFixedDto(entity);
    }
}
