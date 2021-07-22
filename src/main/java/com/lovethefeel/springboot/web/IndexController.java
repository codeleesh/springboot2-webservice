package com.lovethefeel.springboot.web;

import com.lovethefeel.springboot.config.auth.LoginUser;
import com.lovethefeel.springboot.config.auth.dto.SessionUser;
import com.lovethefeel.springboot.service.PostsService;
import com.lovethefeel.springboot.web.dto.LottosPostsListResponseDto;
import com.lovethefeel.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/lottos/posts/save")
    public String postsLottosSave() {
        return "lottos-posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        List<LottosPostsListResponseDto> dtoList = postsService.findByPostsLottosId(id);

        model.addAttribute("post", dto);
        model.addAttribute("postsLottos", dtoList.get(0).getLottoss());

        return "posts-update";
    }
}
