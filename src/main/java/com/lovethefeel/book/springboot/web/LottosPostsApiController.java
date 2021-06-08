package com.lovethefeel.book.springboot.web;

import com.lovethefeel.book.springboot.domain.posts.Posts;
import com.lovethefeel.book.springboot.service.LottosService;
import com.lovethefeel.book.springboot.service.PostsService;
import com.lovethefeel.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LottosPostsApiController {
    private final PostsService postsService;
    private final LottosService lottosService;

    @PostMapping("/api/v1/lottos/posts")
    public Long save(@RequestBody LottosPostsSaveRequestDto requestLottosPostDto) {
        PostsSaveRequestDto requestPostsDto = PostsSaveRequestDto.builder()
                .title(requestLottosPostDto.getTitle())
                .content(requestLottosPostDto.getContent())
                .author(requestLottosPostDto.getAuthor())
                .build();
        Posts posts = postsService.saveLottos(requestPostsDto);

        LottosSaveRequestDto lottoSaveRequestDto = LottosSaveRequestDto.builder()
                .cnt(requestLottosPostDto.getCnt())
                .build();
        return lottosService.save(lottoSaveRequestDto, posts);
    }

    @GetMapping("/api/v1/lottos/posts/{id}")
    public LottosPostsResponseDto findById(@PathVariable Long id) {

        return lottosService.findById(id);
    }
}
