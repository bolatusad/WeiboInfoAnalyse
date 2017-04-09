package com.xupt.zxh.graduation.project.spider.Util;


import org.jsoup.nodes.Document;

/**
 * Created by admin on 2017/4/6.
 */
public class MyPage {

    /**
     * 页面的URL
     */
    private String url;


    /**
     * 重试次数
     */
    private int retry;

  /**
     * dom
     */
    private Document document;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
