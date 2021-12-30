package com.poscoict.hrmaster.web.dto;

import com.poscoict.hrmaster.domain.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
	private String email;
	private String password;
	private String role;

	public Member toEntity() {
		return Member.builder().email(email).password(password).role(role).build();
	}

	@Builder
	public MemberDto(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
}
