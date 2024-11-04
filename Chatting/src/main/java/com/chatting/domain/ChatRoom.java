package com.chatting.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
	private String chatRoomName;
	
	@OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
	private List<ChatMessage> messages = new ArrayList<>();
	
	@OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
	private List<MemberChatRoom> memberChatRooms = new ArrayList<>();
}
