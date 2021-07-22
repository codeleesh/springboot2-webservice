package com.lovethefeel.springboot.service;

import com.lovethefeel.springboot.domain.posts.Posts;
import com.lovethefeel.springboot.domain.posts.PostsLottos;
import com.lovethefeel.springboot.domain.posts.PostsRepository;
import com.lovethefeel.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Posts saveLottos(LottosPostsSaveRequestDto requestDto) {
        String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-lotto";

        PostsSaveRequestDto requestPostsDto = PostsSaveRequestDto.builder()
                .title(formatDate)
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .build();
        return postsRepository.save(requestPostsDto.toEntity());
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<LottosPostsListResponseDto> findByPostsLottosId(Long id) {
        List<PostsLottos> entity = postsRepository.findByPostsLottosId(id);
        return entity.stream()
                .map(LottosPostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
