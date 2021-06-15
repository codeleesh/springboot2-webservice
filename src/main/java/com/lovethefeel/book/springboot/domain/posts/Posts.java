package com.lovethefeel.book.springboot.domain.posts;

import com.lovethefeel.book.springboot.domain.BaseTimeEntity;
import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
    private List<Lottos> lottos = new ArrayList<>();

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void addLottos(Lottos lotto) {
        lottos.add(lotto);
        lotto.setPosts(this);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
