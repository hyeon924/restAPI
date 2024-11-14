package com.example.demo.article.service;

import com.example.demo.article.dto.ArticleDTO;
import com.example.demo.article.entity.Article;
import com.example.demo.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service // 서비스 계층을 나타내는 어노테이션 : 이 클래스가 비즈니스 로직을 처리하는 서비스 계층임을 나타냄
public class ArticleService {// 이곳에 Article과 관련된 비즈니스 로직을 작성
  private final ArticleRepository articleRepository;

//  다건조회(전체)
    public List<ArticleDTO> getList() {
        List<Article> articleList = this.articleRepository.findAll();
        List<ArticleDTO> articleDTOList = articleList.stream()
                .map(article -> new ArticleDTO(article))
                .collect(Collectors.toList());
        return articleDTOList;
    }

//    단건조회(특정)
  public Article getArticle(Long id) {
          Optional<Article> optionalArticle = this.articleRepository.findById(id);
          return optionalArticle.orElse(null);
      }

//      등록
  public Article write(String subject, String content) {
        Article article = Article.builder()
                .subject(subject)
                .content(content)
                .build();
        this.articleRepository.save(article);
        return article;
    }
    
//    수정
  public Article update(Article article, String content, String subject) {
        article.setSubject(subject);
        article.setContent(content);
        this.articleRepository.save(article);
        return article;
    }

// 삭제
    public void delete(Article article) {
        this.articleRepository.delete(article);
    }
}

