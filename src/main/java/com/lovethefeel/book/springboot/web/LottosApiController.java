package com.lovethefeel.book.springboot.web;

import com.lovethefeel.book.springboot.service.LottosService;
import com.lovethefeel.book.springboot.web.dto.LottosSaveRequestDto;
import com.lovethefeel.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LottosApiController {
    private final LottosService lottosService;

    @PostMapping("/api/v1/lottos")
    public Long save(@RequestBody LottosSaveRequestDto requestDto) {
        return lottosService.save(requestDto);
    }
}
