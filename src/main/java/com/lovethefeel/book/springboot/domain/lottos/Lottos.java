package com.lovethefeel.book.springboot.domain.lottos;

import com.lovethefeel.book.springboot.domain.BaseTimeEntity;
import com.lovethefeel.book.springboot.domain.posts.Posts;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Lottos extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cnt;

    private int num1;

    private int num2;

    private int num3;

    private int num4;

    private int num5;

    private int num6;

    @ManyToOne
    @JoinColumn(name="posts_id")
    private Posts posts;

    @Builder
    public Lottos(int cnt, int num1, int num2, int num3, int num4, int num5, int num6, Posts posts) {
        this.cnt = cnt;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
        this.posts = posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
}
