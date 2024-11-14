package com.example.demo.article.controller;

import com.example.demo.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냄. JSON 데이터를 반환(json 형식이 문자열이기 때문에 타임리프가 올 일이 없어 @ResponseBody 어노테이션을 안붙여도 데이터 형태로 넘어감)
@RequiredArgsConstructor // final 필드에 대해 생성자를 자동으로 생성. 의존성 주입을 간결하게 처리
@RequestMapping("api/v1/articles")
public class ApiV1ArticleController { // REST API 엔드포인트를 정의하여 HTTP 요청을 처리
    private final ArticleService articleService; //Article과 관련된 비즈니스 로직을 처리하는 서비스

//    전체조회
    @GetMapping("")
    public String list () {
        return "전체조회";
    }

//    단건(특정)조회
    @GetMapping("/{id}")
    public String getList () {
        return "123";
    }

//    글 등록
    @PostMapping("")
    public String create () {
        return "";
    }

//    글(특정) 수정
    @PatchMapping("/{id}")
    public String modify () {
        return "";
    }

//    글(특정) 삭제
    @DeleteMapping("/{id}")
    public String delete() {
        return "";
    }

}
