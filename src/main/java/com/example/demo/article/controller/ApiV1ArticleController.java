package com.example.demo.article.controller;

import com.example.demo.article.dto.ArticleDTO;
import com.example.demo.article.entity.Article;
import com.example.demo.article.request.ArticleCreateRequest;
import com.example.demo.article.request.ArticleModifyRequest;
import com.example.demo.article.response.ArticleCreateResponse;
import com.example.demo.article.response.ArticleResponse;
import com.example.demo.article.response.ArticlesResponse;
import com.example.demo.article.service.ArticleService;
import com.example.demo.global.RsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냄. JSON 데이터를 반환(json 형식이 문자열이기 때문에 타임리프가 올 일이 없어 @ResponseBody 어노테이션을 안붙여도 데이터 형태로 넘어감)
@RequiredArgsConstructor // final 필드에 대해 생성자를 자동으로 생성. 의존성 주입을 간결하게 처리
@RequestMapping("api/v1/articles")
public class ApiV1ArticleController { // REST API 엔드포인트를 정의하여 HTTP 요청을 처리
    private final ArticleService articleService; //Article과 관련된 비즈니스 로직을 처리하는 서비스

//    전체조회
 @GetMapping("")
    public RsData<ArticlesResponse> list() {
        List<ArticleDTO> articleList = this.articleService.getList();

        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }

//    단건(특정)조회
  @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        ArticleDTO  articleDTO = this.articleService.getArticle(id);

        return RsData.of("200", "게시글 단건 조회 성공", new ArticleResponse(articleDTO));
    }

//    글 등록
    @PostMapping("")
     public RsData<ArticleCreateResponse> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        Article article = this.articleService.write(articleCreateRequest.getSubject(), articleCreateRequest.getContent());

        return RsData.of("200", "등록성공", new ArticleCreateResponse(article));
    }

//    글(특정) 수정
  @PatchMapping("/{id}")
   public String modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        return "수정완료";
    }

//    글(특정) 삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return "삭제완료";
    }

}
