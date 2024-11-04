package com.chatting.domain;

import java.awt.TrayIcon.MessageType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity 
public class ChatMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 500)
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "sender_id", nullable = false)
	private Member sender;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id", nullable = false)
	private Member recevier;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MessageType type; //  메시지 유형 (CHAT, JOIN, LEAVE)
	
	@ManyToOne
	@JoinColumn(name = "chat_room_id", nullable = false)
	private ChatRoom chatRoom; // 채팅방
	
}
