package com.example.article.entity;

import com.example.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity // JPA에서 관리하는 엔티티로 설정. 데이터베이스의 테이블에 매핑
@Getter // 모든 필드의 getter 메서드 자동 생성
@Setter // 모든 필드의 setter 메서드 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성
@NoArgsConstructor // 매개변수가 없는 기본 생성자 자동 생성
@SuperBuilder // 부모 클래스 필드까지 포함한 Builder 패턴 지원
@ToString(callSuper = true) // 부모 클래스의 toString() 결과 포함한 toString() 메서드 자동 생성
public class Article extends BaseEntity { // BaseEntity를 상속받아 id, createdDate, modifiedDate 포함
    private String subject; // 게시물 제목
    private String content; // 게시물 내용
}
