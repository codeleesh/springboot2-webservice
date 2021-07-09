package com.lovethefeel.springboot.web.dto;

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
