package com.lovethefeel.springboot.domain.posts;

import com.lovethefeel.springboot.domain.lottos.Lottos;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.lovethefeel.springboot.domain.posts.QPosts.posts;
import static com.lovethefeel.springboot.domain.lottos.QLottos.lottos;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@RequiredArgsConstructor
public class PostsRepositoryImpl implements PostsRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public List<PostsLottos> findByPostsLottosId(Long id) {
        Map<Posts, List<Lottos>> transform = queryFactory
                .from(posts)
                .leftJoin(posts.lottoss, lottos)
                .where(posts.id.eq(id))
                .transform(groupBy(posts).as(list(lottos)));

        return transform.entrySet().stream()
                .map(entry -> new PostsLottos(entry.getKey().getId(), entry.getKey().getTitle()
                        , entry.getKey().getContent(), entry.getKey().getAuthor(), entry.getKey().getLottoss()))
                .collect(Collectors.toList());
    }
}
