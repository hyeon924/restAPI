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
  public ArticleDTO getArticle(Long id) {
          Optional<Article> optionalArticle = this.articleRepository.findById(id);
          return optionalArticle.map(article -> new ArticleDTO(article)).orElse(null);
      }

}

