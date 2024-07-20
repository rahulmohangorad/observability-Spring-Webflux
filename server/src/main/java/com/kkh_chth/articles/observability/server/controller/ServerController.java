package com.kkh_chth.articles.observability.server.controller;

import com.kkh_chth.articles.observability.server.bean.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ServerController {

    @GetMapping("/server/articles")
    public Mono<List<Article>> getArticleList(){
        List<Article> alist= new ArrayList<>();
        alist.add(new Article(1,"First Article"));
        alist.add(new Article(2,"Second Article"));
        alist.add(new Article(3,"Third Article"));
        alist.add(new Article(4,"Fourth Article"));
        return Mono.just(alist);
    }
}
