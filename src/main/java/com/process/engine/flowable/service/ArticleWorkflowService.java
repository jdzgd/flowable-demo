package com.process.engine.flowable.service;

import com.process.engine.flowable.domain.Article;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.List;

/**
 * @author jiangdongzhao
 * @date 2020/4/27
 */
public interface ArticleWorkflowService {

    /**
     * 启动流程引擎
     * <br/>
     *
     * @param article 文章
     * @author jiangdongzhao
     * @date 2020/4/27
     * @return
     */
    ProcessInstance startProcess(Article article);

    /**
     * 获取任务
     * <br/>
     *
     * @param candidateGroup 组别
     * @return java.util.List<org.flowable.bpmn.model.Task>
     * @author jiangdongzhao
     * @date 2020/4/27
     */
    List<Article> getTasks(String candidateGroup);
}
