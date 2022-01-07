package com.poscoict.hrmaster.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.service.HrAdminService;
import com.poscoict.hrmaster.service.HrBasicService;
import com.poscoict.hrmaster.service.HrFixedService;
import com.poscoict.hrmaster.web.dto.HrAdminDto;
import com.poscoict.hrmaster.web.dto.HrBasicDto;
import com.poscoict.hrmaster.web.dto.HrFileDto;
import com.poscoict.hrmaster.web.dto.HrFixedDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HrApiController {

	private final HrFixedService hrFixedService;
	private final HrBasicService hrBasicService;
	private final HrAdminService hrAdminService;

	// @지수
	// put method for master
	@PutMapping("/api/v1/hrfixed/admin/{id}")
	public Long updateByIdForAdmin(@PathVariable Long id, @RequestBody HrFixedDto hrFixedDto) {

		System.out.println("controller: " + hrFixedDto.getKorName());
		return hrFixedService.updateByIdForAdmin(id, hrFixedDto);
	}

	// @지수
	// put method for employee
	@PutMapping("/api/v1/hrfixed/employee/{id}")
	public Long updateByIdForEmployee(@PathVariable Long id, @RequestBody HrFixedDto hrFixedDto) {

		System.out.println("controller: " + hrFixedDto.getKorName());
		return hrFixedService.updateByIdForEmployee(id, hrFixedDto);
	}

	// @윤욱
	// delete method for employee
	@DeleteMapping("/api/v1/hrfixed/{id}")
	public Long delete(@PathVariable Long id) {
		hrFixedService.delete(id);
		return id;
	}

	// @경빈
	// 메서드 이름 변경: findById -> hrFixedById
	@GetMapping("/api/v1/hrfixed/{id}")
	public HrFixedDto hrFixedfindById(@PathVariable Long id) {
		return hrFixedService.findById(id);
	}

	// @경빈
	// 인사기본 조회 추가
	@GetMapping("/api/v1/hrbasic/{id}")
	public HrBasicDto hrBasicfindById(@PathVariable Long id) {
		return hrBasicService.findById(id);
	}

	// @수현
	// put method for employee(basic)
	@PutMapping("/api/v1/hrbasic/employee/{id}")
	public Long updateByIdForBasicEmployee(@PathVariable Long id, @RequestBody HrBasicDto hrBasicDto) {
		return hrBasicService.updateByIdForEmployee(id, hrBasicDto);

	}

	// @수현
	// 회원 전체 리스트 조회
	@GetMapping("/api/v1/hradmin/admin/list")
	public List<Employee> hrBasicfindAll() {
		return hrAdminService.findByAll();
	}

	// @지수
	// 어드민 사원디테일 조회
	@GetMapping("/api/v1/hradmin/admin/list/{id}")
	public List<Employee> hrAdminfindDetail(@PathVariable Long id) {
		return hrAdminService.findbyIdForDetail(id);
	}

	// @지수
	// 어드민 사원디테일 추가
	@PostMapping("/api/v1/hradmin/admin")
	public Long save(@RequestBody HrAdminDto hrAdminDto) {
		return hrAdminService.saveByAdmin(hrAdminDto);
	}

	// @지수
	// 사진 업로드
	@CrossOrigin("*")
	@PostMapping("/api/v1/hradmin/image" )
	public void saveImageToServer(HrFileDto hrFileDto, MultipartFile img) {
		System.out.println("파일 이름 : " + img.getOriginalFilename());
		System.out.println("파일 타입 : " + img.getContentType());
		System.out.println("파일 크기 : " + img.getSize());
		
		hrAdminService.saveImageToServer(hrFileDto, img);
	}

//	// @지수
//	// 사진 가져오기
//	@CrossOrigin("*")
//	@GetMapping("/api/v1/hradmin/image")
//	public ResponseEntity<byte[]> getImage(String fileName) {
//		File file = new File("C:\\Users\\OWNER\\Pictures\\" + fileName);
//		ResponseEntity<byte[]> result = null;
//
//		try {
//
//			HttpHeaders header = new HttpHeaders();
//			header.add("Content-type", Files.probeContentType(file.toPath()));
//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;
//
//	}

}
