package com.example.demo.article.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class ArticleDTO { // 엔티티는 정보를 저장할때만 사용되고 그 외의 계층간의 쓰임에서는 엔티티를 직접 쓰지 않고 dto를 만들어 쓴다. 이유는 사용자쪽에 노출되면 안되는 값들만을 가지고 개발을 하기 위해서
    // 엔티티에서는 데이터베이스의 테이블과 연결된 정보 값을 설정해줌 (테이블 전용)
    // dto에는 그 중에서도 노출 되는 값들만 가져와서 계층간에서 개발을 함

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
