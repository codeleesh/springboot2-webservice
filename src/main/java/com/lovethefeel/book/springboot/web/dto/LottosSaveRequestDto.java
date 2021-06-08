package com.lovethefeel.book.springboot.web.dto;

import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import com.lovethefeel.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LottosSaveRequestDto {
    private int cnt;
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;
    private Posts posts;

    @Builder
    public LottosSaveRequestDto(int cnt, int num1, int num2, int num3, int num4, int num5, int num6, Posts posts) {
        this.cnt = cnt;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
        this.posts = posts;
    }

    public Lottos toEntity() {
        return Lottos.builder()
                .cnt(cnt)
                .num1(num1)
                .num2(num2)
                .num3(num3)
                .num4(num4)
                .num5(num5)
                .num6(num6)
                .posts(posts)
                .build();
    }
}
