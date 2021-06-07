package com.lovethefeel.book.springboot.domain.lottos;

import com.lovethefeel.book.springboot.domain.posts.Posts;
import com.lovethefeel.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

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

        List<Lottos> lottosList = lottosRepository.findAll();

        //then
        Lottos lottos = lottosList.get(0);

        System.out.println(">>>>>>>>> num1=" + lottos.getNum1() + ", num2=" + lottos.getNum2() +
                ", num3=" + lottos.getNum3() + ", num4=" + lottos.getNum4() +
                ", num5=" + lottos.getNum5() + ", num6=" + lottos.getNum6());
    }
}
