package com.lovethefeel.book.springboot.domain.posts;

import java.util.List;

public interface PostsRepositoryCustom {

    List<PostsLottos> findByPostsLottosId(Long id);
}
