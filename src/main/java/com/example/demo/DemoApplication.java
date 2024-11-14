package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Spring Data JPA의 Auditing 기능을 활성화 (엔티티의 생성 및 수정 시간을 자동 처리)
@SpringBootApplication // Spring Boot 애플리케이션의 시작 지점이며, Configuration, Component Scan, Auto Configuration 기능 포함
public class DemoApplication {

	public static void main(String[] args) {
		// Spring Boot 애플리케이션 실행. 내장된 서버(Tomcat)가 시작되고 필요한 빈이 초기화됨
		SpringApplication.run(DemoApplication.class, args);
	}

}
