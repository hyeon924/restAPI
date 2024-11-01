package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.request.MemberRequest;
import com.example.demo.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/v1/members", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "ApiV1MemberController", description = "회원 인증인가 API")
public class ApiV1MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@Valid @RequestBody MemberRequest memberRequest) {
        this.memberService.join(memberRequest.getUsername(), memberRequest.getPassword());

        return "회원가입 성공";
    }

}
