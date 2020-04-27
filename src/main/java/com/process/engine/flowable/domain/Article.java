package com.process.engine.flowable.domain;

import lombok.Data;

/**
 * @author jiangdongzhao
 * @date 2020/4/27
 */
@Data
public class Article {
    private String id;
    private String title;
    private String content;

    public Article(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
