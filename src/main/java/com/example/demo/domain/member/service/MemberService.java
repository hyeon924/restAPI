package com.example.demo.domain.member.service;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

//  회원 정보 저장(등록)
public void join(String username, String password) {
    Member member = Member.builder()
            .username(username)
            .password(password)
            .build();
    this.memberRepository.save(member);
}
}