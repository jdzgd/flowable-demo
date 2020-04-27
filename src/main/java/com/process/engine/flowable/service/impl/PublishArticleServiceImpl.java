package com.process.engine.flowable.service.impl;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * 此类无法影响流程操作，如果需要影响请用ActivityBehavior
 * @author jiangdongzhao
 * @date 2020/4/27
 */
public class PublishArticleServiceImpl implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("execution");
    }
}
