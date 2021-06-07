package com.lovethefeel.book.springboot.web.dto;

import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import com.lovethefeel.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LottosPostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private int cnt;

    @Builder
    public LottosPostsSaveRequestDto(String title, String content, String author, int cnt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.cnt = cnt;
    }

}
