package com.example.demo.global.jpa;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter // 모든 필드의 getter 메서드를 자동 생성
@SuperBuilder // 상속 관계에서 부모 필드까지 포함한 Builder 패턴 지원
@MappedSuperclass // 다른 엔티티의 부모 클래스로 사용되며, 필드를 자식 엔티티의 테이블에 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 생성하되, 접근 제어자를 protected로 설정
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 활성화 (생성/수정 시간 자동 설정)
@ToString // 모든 필드를 포함하는 toString() 메서드를 자동 생성
public class BaseEntity {
    @Id // 기본 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키를 데이터베이스의 Auto Increment로 생성
    private Long id;

    @CreatedDate // 엔티티가 생성된 시간을 자동으로 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 엔티티가 마지막으로 수정된 시간을 자동으로 저장
    private LocalDateTime modifiedDate;
}

