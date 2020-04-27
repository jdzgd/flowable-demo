package com.process.engine.flowable.service.impl;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.impl.delegate.ActivityBehavior;

/**
 * @author jiangdongzhao
 * @date 2020/4/27
 */
public class TestServiceImpl implements ActivityBehavior {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("动态修改");
    }
}
