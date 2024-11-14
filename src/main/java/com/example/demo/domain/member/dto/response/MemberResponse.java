package com.example.demo.domain.member.dto.response;

import com.example.demo.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private final String username;
    private final LocalDateTime createdDate;
    public MemberResponse(Member article) {
        this.username = article.getUsername();
        this.createdDate = article.getCreatedDate();
    }
}