package com.process.engine.flowable.rest;

import com.process.engine.flowable.constant.ErrorConstant;
import com.process.engine.flowable.domain.Article;
import com.process.engine.flowable.service.ArticleWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

/**
 * @author jiangdongzhao
 * @date 2020/4/27
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleWorkflowService articleWorkflowService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/test")
    public void test(){
        String message = messageSource.getMessage(ErrorConstant.MODEL_KEY_ALREADY_EXISTS, null, Locale.US);
        test2("1a","2a");
        System.out.println(message);
    }

    private void test2(Object... args) {
        String message2 = messageSource.getMessage(ErrorConstant.MODEL_KEY_NOT_FOUND, args,"sdf", Locale.CHINA);
        System.out.println(message2);
    }
    @PostMapping("/start")
    public void start(@RequestBody Article article) {
        articleWorkflowService.startProcess(article);
    }

    @RequestMapping("/task")
    public List<Article> task(String candidateGroup) {
        return articleWorkflowService.getTasks(candidateGroup);
    }
}
