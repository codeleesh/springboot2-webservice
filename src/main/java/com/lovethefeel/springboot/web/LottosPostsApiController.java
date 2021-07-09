package com.lovethefeel.springboot.web;

import com.lovethefeel.springboot.domain.posts.Posts;
import com.lovethefeel.springboot.service.LottosService;
import com.lovethefeel.springboot.service.PostsService;
import com.lovethefeel.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LottosPostsApiController {
    private final PostsService postsService;
    private final LottosService lottosService;

    @PostMapping("/api/v1/lottos/posts")
    public Long save(@RequestBody LottosPostsSaveRequestDto requestLottosPostDto) {
        Posts posts = postsService.saveLottos(requestLottosPostDto);
        return lottosService.save(requestLottosPostDto, posts);
    }
}
