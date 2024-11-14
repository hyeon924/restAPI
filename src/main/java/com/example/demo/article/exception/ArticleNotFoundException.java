package com.example.demo.article.exception;

public class ArticleNotFoundException extends RuntimeException {
    private final Long id;

    public ArticleNotFoundException(Long id) {
        super("게시글 " + id + "은(는) 존재하지 않습니다.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

