package com.lovethefeel.book.springboot.domain.posts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import com.lovethefeel.book.springboot.domain.lottos.LottosRepository;
import com.lovethefeel.book.springboot.web.dto.LottosPostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        List<PostsLottos> postsLottos = postsRepository.findByPostsLottosId(1L);

        //then
        assertThat(postsLottos.size()).isEqualTo(1);
        assertThat(postsLottos.get(0).getId()).isEqualTo(1);
        assertThat(postsLottos.get(0).getLottoss().get(0).getCnt()).isEqualTo(5);
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

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
