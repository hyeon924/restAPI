package com.example.demo.domain.article.controller;

import com.example.demo.domain.article.dto.ArticleDTO;
import com.example.demo.domain.article.entity.Article;
import com.example.demo.domain.article.exception.ArticleNotFoundException;
import com.example.demo.domain.article.dto.request.ArticleCreateRequest;
import com.example.demo.domain.article.dto.request.ArticleModifyRequest;
import com.example.demo.domain.article.dto.response.ArticleCreateResponse;
import com.example.demo.domain.article.dto.response.ArticleModifyResponse;
import com.example.demo.domain.article.dto.response.ArticleResponse;
import com.example.demo.domain.article.dto.response.ArticlesResponse;
import com.example.demo.domain.article.service.ArticleService;
import com.example.demo.global.RsData.RsData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
// 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냄. JSON 데이터를 반환(json 형식이 문자열이기 때문에 타임리프가 올 일이 없어 @ResponseBody 어노테이션을 안붙여도 데이터 형태로 넘어감)
@RequiredArgsConstructor // final 필드에 대해 생성자를 자동으로 생성. 의존성 주입을 간결하게 처리
@RequestMapping(value = "/api/v1/articles")
@Tag(name = "ApiV1ArticleController", description = "게시글 CRUD API")
public class ApiV1ArticleController { // REST API 엔드포인트를 정의하여 HTTP 요청을 처리
  private final ArticleService articleService; //Article과 관련된 비즈니스 로직을 처리하는 서비스

  //    전체조회
  @GetMapping("")
  @Operation(summary = "게시글 다건 조회")
  public RsData<ArticlesResponse> list() {
    List<ArticleDTO> articleList = this.articleService.getList();

    return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
  }

  //    단건(특정)조회
  @GetMapping("/{id}")
  @Operation(summary = "게시글 단건 조회")
  public RsData<?> getArticle(@PathVariable("id") Long id) {
    try {
      Article article = this.articleService.getArticle(id);
      ArticleDTO articleDTO = new ArticleDTO(article);
      return RsData.of("200", "게시글 단건 조회 성공", new ArticleResponse(articleDTO));
    } catch (ArticleNotFoundException e) {
      return RsData.of("404", e.getMessage(), Map.of("id", e.getId()));
    }
  }


  //    글 등록
  @PostMapping("")
  @Operation(summary = "게시글 등록")
  public RsData<ArticleCreateResponse> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
    Article article = this.articleService.write(articleCreateRequest.getSubject(), articleCreateRequest.getContent());

    return RsData.of("200", "등록성공", new ArticleCreateResponse(article));
  }

  //    글(특정) 수정
  @PatchMapping("/{id}")
  @Operation(summary = "게시글 수정")
  public RsData<ArticleModifyResponse> modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
    Article article = this.articleService.getArticle(id);

    if (article == null) return RsData.of(
        "500",
        "%d 번 게시물은 존재하지 않습니다.".formatted(id),
        null
    );
    article = this.articleService.update(article, articleModifyRequest.getSubject(), articleModifyRequest.getContent());

    return RsData.of("200", "수정성공", new ArticleModifyResponse(article));
  }

  //    글(특정) 삭제
  @DeleteMapping("/{id}")
  @Operation(summary = "게시글 삭제")
  public RsData<ArticleResponse> delete(@PathVariable("id") Long id) {
    Article article = this.articleService.getArticle(id);
    if (article == null) return RsData.of(
        "500",
        "%d 번 게시물은 존재하지 않습니다.".formatted(id),
        null
    );
    this.articleService.delete(article);
    ArticleDTO articleDTO = new ArticleDTO(article);

    return RsData.of("200", "삭제성공", new ArticleResponse(articleDTO));
  }

}
