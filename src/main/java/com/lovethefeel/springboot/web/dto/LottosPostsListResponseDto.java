package com.lovethefeel.springboot.web.dto;

import com.lovethefeel.springboot.domain.lottos.Lottos;
import com.lovethefeel.springboot.domain.posts.PostsLottos;
import lombok.Getter;

import java.util.List;


@Getter
public class LottosPostsListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<Lottos> lottoss;

    public LottosPostsListResponseDto(PostsLottos entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.lottoss = entity.getLottoss();
    }
}
