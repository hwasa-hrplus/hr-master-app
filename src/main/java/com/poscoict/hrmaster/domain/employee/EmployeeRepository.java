package com.poscoict.hrmaster.domain.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByEmail(String userEmail);
	 
	@Query(value = "SELECT * from Employee where role='팀장'", nativeQuery = true)
	 List<Employee> findBoss();
}
