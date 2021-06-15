package com.lovethefeel.book.springboot.web.dto;

import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import com.lovethefeel.book.springboot.domain.posts.PostsLottos;
import lombok.Getter;

import java.util.List;

@Getter
public class LottosPostsResponseDto {

    private String title;
    private List<Lottos> lottos;

    public LottosPostsResponseDto(PostsLottos entity) {
        this.title = entity.getPostsTitle();
        this.lottos = entity.getLotto();
    }
}
