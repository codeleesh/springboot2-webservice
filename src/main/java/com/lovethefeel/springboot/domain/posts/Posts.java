package com.lovethefeel.springboot.domain.posts;

import com.lovethefeel.springboot.domain.BaseTimeEntity;
import com.lovethefeel.springboot.domain.lottos.Lottos;
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

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Lottos> lottoss = new ArrayList<>();

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void addLottos(Lottos lottos) {
        lottoss.add(lottos);
        lottos.setPosts(this);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
