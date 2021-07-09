package com.lovethefeel.springboot.domain.posts;

import com.lovethefeel.springboot.domain.lottos.Lottos;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostsLottos {
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<Lottos> lottoss;
    @Builder
    public PostsLottos(Long id, String title, String content, String author
            , List<Lottos> lottoss) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.lottoss = lottoss;
    }
}
