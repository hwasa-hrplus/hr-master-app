package com.poscoict.hrmaster.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.employee.EmployeeRepository;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @Autowired 없이 생성자로 주입하는 방식
//final이 선언된 필드를 인자값으로 하는 생성자를 생성함
@Service

// @경빈
// 클래스 이름 변경: HrService -> HrFixedService
public class HrFixedService {
	private final EmployeeRepository employeeRepository;

	public HrFixedDto findById(Long id) {
		Employee entity = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다. id=" + id));

		return new HrFixedDto(entity);
	}


	// put method for employee
	@Transactional
	public Long updateByIdForEmployee(Long id, HrFixedDto hrFixedDto) {
		Employee entity = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 사용자 업데이트 정보가 없습니다.(for employee) id=" + id));
		
		System.out.println("service: " + hrFixedDto.getEngName());

		Map<String, Object> employeeInfo = new HashMap<String, Object>();
		employeeInfo.put("korName", hrFixedDto.getKorName());
		employeeInfo.put("engName", hrFixedDto.getEngName());
		employeeInfo.put("filesId", hrFixedDto.getFilesId());
		
		entity.updateForEmployee(employeeInfo);
		return id;
	}
	
	//@수현
	// post for admin 
    @Transactional
    public Long saveByAdmin(HrFixedDto hrFixedDto){

        return employeeRepository.save(hrFixedDto.toEntity()).getId();
    }
	
	// @수현
	// 인사고정 정보 전체 리스트 조회
	public List<Employee> findByAll() {
		List<Employee> employee_list= employeeRepository.findAll();
				//.orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다. id=" + id));

		return employee_list;
	}
	
}
