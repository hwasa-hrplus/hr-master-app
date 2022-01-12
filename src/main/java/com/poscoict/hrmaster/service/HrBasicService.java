package com.poscoict.hrmaster.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.employee.EmployeeRepository;
import com.poscoict.hrmaster.web.dto.HrBasicDto;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //@Autowired 없이 생성자로 주입하는 방식
//final이 선언된 필드를 인자값으로 하는 생성자를 생성함
@Service

// @경빈
// 인사 기본 관련 서비스 생성
public class HrBasicService {
	private final EmployeeRepository employeeRepository;
	
	public HrBasicDto findById(Long id){
        Employee entity = employeeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 정보가 없습니다. id="+ id));
      
        return new HrBasicDto(entity);
    }
	
	//@수현
	// put method for employee(basic)
	@Transactional
	public Long updateByIdForEmployee(Long id, HrBasicDto hrBasicDto) {
		Employee entity = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 사용자 업데이트 정보가 없습니다.(for employee) id=" + id));
		

		Map<String, Object> employeeInfo = new HashMap<String, Object>();
		employeeInfo.put("phone", hrBasicDto.getPhone());
		employeeInfo.put("address", hrBasicDto.getAddress());
		employeeInfo.put("addressDetail", hrBasicDto.getAddressDetail());
		
		entity.updateForBasicEmployee(employeeInfo);
		return id;
	}
}
