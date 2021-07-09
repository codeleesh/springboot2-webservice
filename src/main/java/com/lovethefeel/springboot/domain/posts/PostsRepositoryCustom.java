package com.lovethefeel.springboot.domain.posts;

import java.util.List;

public interface PostsRepositoryCustom {

    List<PostsLottos> findByPostsLottosId(Long id);
}
