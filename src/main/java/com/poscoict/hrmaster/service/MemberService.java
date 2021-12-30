package com.poscoict.hrmaster.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.employee.EmployeeRepository;
import com.poscoict.hrmaster.web.dto.MemberDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
	private EmployeeRepository employeeRepository;

	/** * 회원가입 처리 * @param memberDto * @return */
	@Transactional
	public Long joinUser(MemberDto MemberDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 비밀번호 암호화 처리
		MemberDto.setPassword(passwordEncoder.encode(MemberDto.getPassword()));
		return employeeRepository.save(MemberDto.toEntity()).getId();
	}
	
	/**
	 * * 상세 정보 조회 * Security 지정 서비스이므로 필수 구현 * @param email * @return 사용자의 계정정보와 권한을
	 * 갖는 UserDetails 인터페이스 반환 * @throws UsernameNotFoundException
	 */
	@Override
	public Employee loadUserByUsername(String email) throws UsernameNotFoundException {
		return employeeRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException((email)));
	}
}
