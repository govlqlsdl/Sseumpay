package com.kobi.sseumpay.user.domain;

import java.time.LocalDate;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private int id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private LocalDate birthDate;
	private String createdAt;
	private String updatedAt;
}