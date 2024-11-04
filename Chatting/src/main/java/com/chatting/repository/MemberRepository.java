package com.chatting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatting.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Optional<Member> findByUserId(String userId);
}
