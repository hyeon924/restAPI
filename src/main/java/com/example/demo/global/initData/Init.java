package com.example.demo.global.initData;

import com.example.demo.domain.article.service.ArticleService;
import com.example.demo.domain.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Init {
    @Bean
    CommandLineRunner initData(ArticleService articleService, MemberService memberService) {

        return args -> {
            memberService.join("admin", "1234");
            memberService.join("user1", "1234");
            memberService.join("user2", "1234");
            memberService.join("user3", "1234");
            memberService.join("user4", "1234");

            articleService.write("제목 1", "내용 1");
            articleService.write("제목 2", "내용 2");
            articleService.write("제목 3", "내용 3");
            articleService.write("제목 4", "내용 4");
            articleService.write("제목 5", "내용 5");
            articleService.write("제목 6", "내용 6");
        };
    }
}
