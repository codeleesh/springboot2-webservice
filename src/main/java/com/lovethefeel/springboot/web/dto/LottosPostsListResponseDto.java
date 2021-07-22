package com.lovethefeel.springboot.web.dto;

import com.lovethefeel.springboot.domain.lottos.Lottos;
import com.lovethefeel.springboot.domain.posts.PostsLottos;
import lombok.Getter;

import java.util.List;


@Getter
public class LottosPostsListResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Lottos> lottoss;

    public LottosPostsListResponseDto(PostsLottos entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.lottoss = entity.getLottoss();
    }
}
