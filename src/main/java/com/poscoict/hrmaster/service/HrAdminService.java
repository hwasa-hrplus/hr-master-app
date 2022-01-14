package com.poscoict.hrmaster.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.poscoict.hrmaster.domain.department.Department;
import com.poscoict.hrmaster.domain.department.DepartmentRepository;
import com.poscoict.hrmaster.domain.employee.Employee;
import com.poscoict.hrmaster.domain.employee.EmployeeRepository;
import com.poscoict.hrmaster.domain.files.Files;
import com.poscoict.hrmaster.domain.files.FilesRepository;
import com.poscoict.hrmaster.domain.jobcategory.JobCategory;
import com.poscoict.hrmaster.domain.jobcategory.JobCategoryRepository;
import com.poscoict.hrmaster.domain.stafflevel.StaffLevel;
import com.poscoict.hrmaster.domain.stafflevel.StaffLevelRepository;
import com.poscoict.hrmaster.domain.workplace.WorkPlace;
import com.poscoict.hrmaster.domain.workplace.WorkPlaceRepository;
import com.poscoict.hrmaster.web.dto.HrAdminDto;
import com.poscoict.hrmaster.web.dto.HrFileDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @Autowired 없이 생성자로 주입하는 방식
@Service

public class HrAdminService {
	private final EmployeeRepository employeeRepository;
	private final FilesRepository fileRepository;
	private final StaffLevelRepository stafflevelRepository;
	private final DepartmentRepository departmentRepository;
	private final WorkPlaceRepository workPlaceRepository;
	private final JobCategoryRepository jobCategoryRepository;

	// @지수
	// 어드민 아이디로 사원 조회
	public List<Employee> findbyIdForDetail(Long id) {
		Employee entity = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다. id=" + id));

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(entity);

		return employeeList;
	}

	// @수현
	// 사원 전체 리스트 조회
	public List<Employee> findByAll() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}

	// @지수
	// 어드민 사원 추가
	public Long saveByAdmin(HrAdminDto hrAdminDto) {
		return employeeRepository.save(hrAdminDto.toEntity()).getId();

	}

	// @지수
	// 사진 추가
    @Transactional
	public ResponseEntity<HrFileDto> saveImageToServer(HrFileDto hrFileDto, MultipartFile img, Long id ) {
		String uploadFolder = "C:\\upload";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		String datePath = str.replace("-", File.separator);
		
		/* 폴더 생성 */
		File uploadPath = new File(uploadFolder, datePath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		/* 파일 이름 */
		String uploadFileName = img.getOriginalFilename();

		/* uuid 적용 파일 이름 */
		String uuid = UUID.randomUUID().toString();
		uploadFileName = uuid + "_" + uploadFileName;

		/* 파일 위치, 파일 이름을 합친 File 객체 */
		File saveFile = new File(uploadPath, uploadFileName);
		
		hrFileDto.setUserId(id);
		hrFileDto.setName(uploadFileName);
		hrFileDto.setPath(datePath);
		hrFileDto.setUuid(uuid);
		
		fileRepository.save(hrFileDto.toEntity()).getUuid();

		/* 파일 저장 */
		try {
			img.transferTo(saveFile);
			File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

			BufferedImage bo_image = ImageIO.read(saveFile);
			/* 비율 */
			double ratio = 3;
			/* 넓이 높이 */
			int width = (int) (bo_image.getWidth() / ratio);
			int height = (int) (bo_image.getHeight() / ratio);

			BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

			Graphics2D graphic = bt_image.createGraphics();

			graphic.drawImage(bo_image, 0, 0, width, height, null);

			ImageIO.write(bt_image, "jpg", thumbnailFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<HrFileDto> result = new ResponseEntity<HrFileDto>(hrFileDto, HttpStatus.OK);

		return result;

	}
    
	//@지수
	//사진 가져오기
	public HrFileDto findFileById(Long id) {
		Files files = fileRepository.findByUserId(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다. id=" + id));

		return new HrFileDto(files);
	}

	// @지수
	// 직책 가져오기
    @Transactional
	public List<StaffLevel> findByAllStafflevel() {
		List<StaffLevel> staffLevel = stafflevelRepository.findAll();
		return staffLevel;

	}

	// @지수
	// 부서 가져오기
    @Transactional
	public List<Department> findByAllDepartment() {
		List<Department> department = departmentRepository.findAll();
		return department;
	}

    // @지수
 	// 근무장소 가져오기
    @Transactional
	public List<WorkPlace> findByAllWorkPlace() {
		List<WorkPlace> workplace = workPlaceRepository.findAll();
		return workplace;
	}

    // @지수
 	// 직렬 가져오기
    @Transactional
	public List<JobCategory> findByAllJobCategory() {
		List<JobCategory> jobCategory = jobCategoryRepository.findAll();
		return jobCategory;
	}

	// @지수
	// 결재권자 가져오기
    @Transactional  
	public List<Employee> findBoss() {
    	 return employeeRepository.findBoss();
	}



}