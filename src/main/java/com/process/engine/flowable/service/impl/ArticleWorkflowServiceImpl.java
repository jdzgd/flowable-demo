package com.process.engine.flowable.service.impl;

import com.process.engine.flowable.domain.Article;
import com.process.engine.flowable.service.ArticleWorkflowService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jiangdongzhao
 * @date 2020/4/27
 */
@Service
public class ArticleWorkflowServiceImpl implements ArticleWorkflowService {

    RuntimeService runtimeService;
    TaskService taskService;

    private static final String PROCESS_INSTANCE_KEY="articleReview";
    @Autowired
    public ArticleWorkflowServiceImpl(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @Override
    public ProcessInstance startProcess(Article article) {
        Map<String, Object> param = new HashMap<>();
        param.put("title", article.getTitle());
        param.put("content", article.getContent());
        return runtimeService.startProcessInstanceByKey(PROCESS_INSTANCE_KEY, article.getId(), param);
    }

    @Override
    public List<Article> getTasks(String candidateGroup) {

        List<Task> tasks = taskService.createTaskQuery()
            .taskCandidateGroup(candidateGroup)
            .list();

        return tasks.stream().map(x -> {
            Map<String, Object> variables = taskService.getVariables(x.getId());
            // 可能造成NPE
            return new Article(null,variables.get("title").toString(),variables.get("content").toString());
        }).collect(Collectors.toList());
    }
}
