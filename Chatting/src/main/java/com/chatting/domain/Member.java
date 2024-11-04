package com.chatting.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false, unique = true)
	private String memberId; // ID
	
	@Column(length = 45, nullable = false)
	private String memberName; // 이름
	
	@Column(length = 255, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<MemberChatRoom> memberChatRooms = new HashSet<>(); // 참여한 채팅 목록 
}
