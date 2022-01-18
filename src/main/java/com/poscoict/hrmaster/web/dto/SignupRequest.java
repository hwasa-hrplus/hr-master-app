package com.poscoict.hrmaster.web.dto;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
	@NotBlank
	@Email
	@Size(min = 6, max = 40)
	private String username;

	private Set<String> role;

	@NotBlank
	private String korName;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	private Long id;

	public SignupRequest(@NotBlank @Email @Size(min = 6, max = 40) String username, Set<String> role,
			@NotBlank String korName, @NotBlank @Size(min = 6, max = 40) String password, Long id) {
		super();
		this.username = username;
		this.role = role;
		this.korName = korName;
		this.password = password;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getKorName() {
		return korName;
	}

	public void setKorName(String korName) {
		this.korName = korName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
}