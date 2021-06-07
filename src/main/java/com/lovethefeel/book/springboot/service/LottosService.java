package com.lovethefeel.book.springboot.service;

import com.lovethefeel.book.springboot.domain.lottos.LottosRepository;
import com.lovethefeel.book.springboot.domain.posts.PostsRepository;
import com.lovethefeel.book.springboot.web.dto.LottosSaveRequestDto;
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
    public Long save(LottosSaveRequestDto requestDto) {

        final int reqCnt = requestDto.getCnt();
        long result = 0;

        for ( int i = 1; i <= reqCnt; i++ ) {
            List<Integer> lottoNum = new ArrayList<Integer>();
            for ( int j = 1; j <= 45; j++ ) {
                lottoNum.add(i);
            }
            Collections.shuffle(lottoNum);

            int[] lottoNums = new int[6];
            for ( int j = 0; j < 6; j++ ) {
                lottoNums[j] = lottoNum.get(j);
            }
            Arrays.sort(lottoNums);

            result = lottosRepository.save(requestDto.toEntity()).getId();
        }

        return result;
    }

}
