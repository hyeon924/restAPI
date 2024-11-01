package com.example.demo.domain.article.response;

import com.example.demo.domain.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticlesResponse {
    private final List<ArticleDTO> articleList;
}