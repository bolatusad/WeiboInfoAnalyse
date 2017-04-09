package com.xupt.zxh.graduation.project.service.semantic.impl;

import com.xupt.zxh.graduation.project.service.semantic.ISemanticService;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public class SemanticServiceImpl implements ISemanticService {

    //波森语义分析，密钥
    private static final String token = "xvqY6xXA.14186.EQST-_sWWOW";

    //波森语义分析，情感分析URL，直接拼接上 weibo，API上有多种类型
    private static final String url = "http://api.bosonnlp.com/sentiment/analysis?weibo";



    @Override
    public void getSemantic(List<String> contents) {

    }
}
