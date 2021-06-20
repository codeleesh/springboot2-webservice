package com.lovethefeel.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovethefeel.book.springboot.domain.lottos.Lottos;
import com.lovethefeel.book.springboot.domain.lottos.LottosRepository;
import com.lovethefeel.book.springboot.domain.posts.PostsRepository;
import com.lovethefeel.book.springboot.web.dto.LottosPostsSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LottosPostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LottosRepository lottosRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        lottosRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void LottosPosts_등록된다() throws Exception {
        //given
        String title = "title";
        String content = "content";
        int cnt = 5;

        LottosPostsSaveRequestDto requestLottosPostsRequestDto = LottosPostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .cnt(5)
                .build();

        String url = "http://localhost:" + port + "/api/v1/lottos/posts";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestLottosPostsRequestDto)))
                .andExpect(status().isOk());

        //then
        List<Lottos> all = lottosRepository.findAll();
        assertThat(all.size()).isEqualTo(cnt);

    }
}
