package com.lovethefeel.book.springboot.web;

import com.lovethefeel.book.springboot.service.LottosService;
import com.lovethefeel.book.springboot.service.PostsService;
import com.lovethefeel.book.springboot.web.dto.LottosPostsSaveRequestDto;
import com.lovethefeel.book.springboot.web.dto.LottosSaveRequestDto;
import com.lovethefeel.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        postsService.save(requestPostsDto);

        LottosSaveRequestDto requestLottosDto = LottosSaveRequestDto.builder()
                .cnt(requestLottosPostDto.getCnt())
                .build();
        return lottosService.save(requestLottosDto);
    }

}
