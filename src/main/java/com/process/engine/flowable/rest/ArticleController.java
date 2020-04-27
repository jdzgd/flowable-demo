package com.process.engine.flowable.rest;

import com.process.engine.flowable.domain.Article;
import com.process.engine.flowable.service.ArticleWorkflowService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiangdongzhao
 * @date 2020/4/27
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleWorkflowService articleWorkflowService;


    @PostMapping("/start")
    public void start(@RequestBody Article article) {
        articleWorkflowService.startProcess(article);
    }

    @RequestMapping("/task")
    public List<Article> task(String candidateGroup) {
        return articleWorkflowService.getTasks(candidateGroup);
    }
}
