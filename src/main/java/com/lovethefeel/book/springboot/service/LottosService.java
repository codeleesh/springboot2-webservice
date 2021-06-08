package com.lovethefeel.book.springboot.service;

import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import com.lovethefeel.book.springboot.domain.lottos.LottosRepository;
import com.lovethefeel.book.springboot.domain.posts.Posts;
import com.lovethefeel.book.springboot.domain.posts.PostsRepository;
import com.lovethefeel.book.springboot.web.dto.LottosPostsResponseDto;
import com.lovethefeel.book.springboot.web.dto.LottosSaveRequestDto;
import com.lovethefeel.book.springboot.web.dto.PostsResponseDto;
import com.lovethefeel.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LottosService {
    private final LottosRepository lottosRepository;

    @Transactional
    public Long save(LottosSaveRequestDto requestDto, Posts posts) {

        final int reqCnt = requestDto.getCnt();
        long result = 0;

        for ( int i = 1; i <= reqCnt; i++ ) {
            List<Integer> lottoNum = new ArrayList<Integer>();
            for ( int j = 1; j <= 45; j++ ) {
                lottoNum.add(j);
            }
            Collections.shuffle(lottoNum);

            int[] lottoNums = new int[6];
            for ( int j = 0; j < 6; j++ ) {
                lottoNums[j] = lottoNum.get(j);
            }
            Arrays.sort(lottoNums);

            requestDto = LottosSaveRequestDto.builder()
                    .cnt(requestDto.getCnt())
                    .num1(lottoNums[0])
                    .num2(lottoNums[1])
                    .num3(lottoNums[2])
                    .num4(lottoNums[3])
                    .num5(lottoNums[4])
                    .num6(lottoNums[5])
                    .posts(posts)
                    .build();

            result = lottosRepository.save(requestDto.toEntity()).getId();
        }

        return result;
    }

    @Transactional(readOnly = true)
    public LottosPostsResponseDto findById(Long id) {
        Lottos entity = lottosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new LottosPostsResponseDto(entity);
    }
}
