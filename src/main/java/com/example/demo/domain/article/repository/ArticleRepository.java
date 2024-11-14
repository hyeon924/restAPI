package com.example.demo.domain.article.repository;

import com.example.demo.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 데이터 액세스 계층(Repository 계층)을 나타내는 어노테이션.
public interface ArticleRepository extends JpaRepository<Article, Long> {// JpaRepository가 제공하는 주요 메서드 : 기본 CRUD 및 페이징/정렬 기능을 자동으로 제공
}

