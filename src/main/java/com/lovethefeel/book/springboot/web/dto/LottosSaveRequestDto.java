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
    private Posts posts;

    @Builder
    public LottosSaveRequestDto(int cnt, Posts posts) {
        this.cnt = cnt;
        this.posts = posts;
    }

    public Lottos toEntity() {
        return Lottos.builder()
                .cnt(cnt)
                .posts(posts)
                .build();
    }
}
