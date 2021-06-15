package com.lovethefeel.book.springboot.domain.posts;

import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostsLottos {

    private String postsTitle;
    private String postsAuthor;
    private String postsContent;
    private List<Lottos> lotto = new ArrayList<>();

}
