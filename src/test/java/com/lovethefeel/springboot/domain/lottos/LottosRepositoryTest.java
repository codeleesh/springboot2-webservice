package com.lovethefeel.springboot.domain.lottos;

import com.lovethefeel.springboot.domain.posts.Posts;
import com.lovethefeel.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LottosRepositoryTest {

    @Autowired
    LottosRepository lottosRepository;

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        lottosRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        lottosRepository.deleteAll();
        postsRepository.deleteAll();
    }

    @Test
    public void 로또_저장하기() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        Posts posts = Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();
        postsRepository.save(posts);

        lottosRepository.save(Lottos.builder()
                .cnt(1)
                .num1(10)
                .num2(15)
                .num3(18)
                .num4(25)
                .num5(33)
                .num6(42)
                .posts(posts)
                .build());

        //when
        List<Lottos> lottosList = lottosRepository.findAll();

        //then
        Lottos lottos = lottosList.get(0);
        assertThat(lottos.getNum1()).isEqualTo(10);
    }
}
