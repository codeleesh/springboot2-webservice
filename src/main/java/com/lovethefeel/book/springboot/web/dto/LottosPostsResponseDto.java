package com.lovethefeel.book.springboot.web.dto;

import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import com.lovethefeel.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class LottosPostsResponseDto {

    private Long id;
    private int cnt;
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;
    private Long postId;

    public LottosPostsResponseDto(Lottos entity) {
        this.id = entity.getId();
        this.num1 = entity.getNum1();
        this.num2 = entity.getNum2();
        this.num3 = entity.getNum3();
        this.num4 = entity.getNum4();
        this.num5 = entity.getNum5();
        this.num6 = entity.getNum6();
        this.postId = entity.getPosts().getId();
    }
}
