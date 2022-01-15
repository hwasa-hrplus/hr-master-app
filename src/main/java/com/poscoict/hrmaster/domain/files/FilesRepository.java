package com.poscoict.hrmaster.domain.files;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
	
	Optional<Files> findByUserId(Long user_id);
}
