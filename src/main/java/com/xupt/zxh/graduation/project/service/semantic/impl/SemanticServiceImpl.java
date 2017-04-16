package com.xupt.zxh.graduation.project.service.semantic.impl;

import com.alibaba.fastjson.JSON;
import com.xupt.zxh.graduation.project.service.semantic.ISemanticService;
import com.xupt.zxh.graduation.project.util.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
@Service
public class SemanticServiceImpl implements ISemanticService {

    //波森语义分析，密钥
    private static final String token = "xvqY6xXA.14186.EQST-_sWWOW7";

    //波森语义分析，情感分析URL，直接拼接上 weibo，API上有多种类型
    private static final String url = "http://api.bosonnlp.com/sentiment/analysis?weibo";



    @Override
    public void getSemantic(List<String> contents) throws IOException {
        if(contents == null || contents.size()<=0){
            return ;
        }
        String jsonContent = JSON.toJSONString(contents);
        String result = postForResult(url,jsonContent,token);
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        SemanticServiceImpl semanticService = new SemanticServiceImpl();
        List<String> temp = new ArrayList<String>();
        temp.add("我不开心");
        temp.add("我喜欢你");
        semanticService.getSemantic(temp);
    }

    /**
     * 用于语义分析
     * @return
     */
    public String postForResult(String url,String contents,String tooken) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("X-Token",tooken);
        StringEntity entity = new StringEntity(contents, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity responseEntity = httpResponse.getEntity();
        System.out.println(EntityUtils.toString(responseEntity));
        return null;

    }
}
