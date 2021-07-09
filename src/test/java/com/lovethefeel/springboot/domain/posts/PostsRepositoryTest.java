package com.lovethefeel.springboot.domain.posts;

import com.lovethefeel.springboot.domain.lottos.Lottos;
import com.lovethefeel.springboot.domain.lottos.LottosRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    LottosRepository lottosRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        lottosRepository.deleteAll();
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("lovethefeel@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void 로또게시글저장_불러오기() throws Exception {

        //given
        Posts posts = Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();
        postsRepository.save(posts);

        int cnt = 5;
        lottosRepository.save(Lottos.builder()
                .cnt(cnt)
                .num1(10)
                .num2(15)
                .num3(18)
                .num4(25)
                .num5(33)
                .num6(42)
                .posts(posts)
                .build());

        //when
        List<PostsLottos> postsLottosList = postsRepository.findByPostsLottosId(1L);

        //then
/*        PostsLottos postsLottos = postsLottosList.get(0);
        assertThat(postsLottos.getId()).isEqualTo(1);
        assertThat(postsLottos.getLottoss().get(0).getCnt()).isEqualTo(5);*/
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
