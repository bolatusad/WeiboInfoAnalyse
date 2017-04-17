package com.xupt.zxh.graduation.project.service.semantic.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboEmotion;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.service.semantic.ISemanticService;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboInfoService;
import com.xupt.zxh.graduation.project.service.weibo.impl.IWeiboEmotionService;
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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
@Service
public class SemanticServiceImpl implements ISemanticService {

    private static Logger logger = Logger.getLogger(SemanticServiceImpl.class);

    //波森语义分析，密钥
    private static final String token = "xvqY6xXA.14186.EQST-_sWWOW7";

    //波森语义分析，情感分析URL，直接拼接上 weibo，API上有多种类型
    private static final String url = "http://api.bosonnlp.com/sentiment/analysis?weibo";


    @Autowired
    private IWeiboInfoService weiboInfoService;

    @Autowired
    private IWeiboEmotionService weiboEmotionService;

    @Override
    public List<WeiboEmotion> getSemantic(List<String> contents) throws IOException {
        List<WeiboEmotion> weiboEmotions = new ArrayList<WeiboEmotion>();
        if(contents == null || contents.size()<=0){
            return weiboEmotions;
        }
        String jsonContent = JSON.toJSONString(contents);
//        String result = postForResult(url,jsonContent,token);
        String result = "[[0.1724452534211558, 0.8275547465788442], [0.4787865331070966, 0.5212134668929034], [0.9955046099661772, 0.004495390033822771], [0.8093759124900808, 0.19062408750991924], [0.39585670810082285, 0.6041432918991771]]";
        System.out.println(result);
        JSONArray jsonResult = JSON.parseArray(result);
        for (Object object : jsonResult){
            WeiboEmotion weiboEmotion = new WeiboEmotion();
            JSONArray temp = JSON.parseArray(object.toString());
            String positive = temp.get(0).toString();
            weiboEmotion.setPositive(Double.parseDouble(positive));
            weiboEmotions.add(weiboEmotion);
        }
//        weiboEmotions = JSON.parseArray(result,WeiboEmotion.class);
        return weiboEmotions;
    }

//    public static void main(String[] args) throws IOException {
//        SemanticServiceImpl semanticService = new SemanticServiceImpl();
//        List<String> temp = new ArrayList<String>();
//        temp.add("我不开心");
//        temp.add("我喜欢你");
//        String result = semanticService.postForResult(url, JSON.toJSONString(temp), token);
//        System.out.println(result);
//    }


    @Override
    public void getSemanticByWeiboInfo(List<WeiboInfo> weiboInfos) throws IOException {
        //判断微博数量的总长度
        if(weiboInfos == null || weiboInfos.size()<=0){
            logger.error("微博的长度为零，即没有最新的微博");
            return;
        }
        List<String> constants = new ArrayList<String>();
        //如果微博不是转发微博则，选取微博内容；如果是转发微博则选取转发理由
        for(WeiboInfo weiboInfo : weiboInfos){
            if(weiboInfo.getIsForward() == 1){
                constants.add(weiboInfo.getReasonOfForward());
            }else {
                constants.add(weiboInfo.getWeiboContent());
            }
        }

        List<WeiboEmotion> weiboEmotions = getSemantic(constants);
        if(weiboEmotions.size() != constants.size()){
            logger.error("情感分析出错，获取的情感分析数量与输入不匹配");
        }else{
            for(int i = 0;i<weiboInfos.size();i++){
                weiboEmotions.get(i).setWeiboId(weiboInfos.get(i).getId());
            }
        }

//        System.out.println(JSON.toJSONString(weiboEmotions));
        weiboEmotionService.insertWeiboEmotions(weiboEmotions);
    }


    @Override
    public void setSemantic() throws IOException {
        List<WeiboInfo> weiboInfos = weiboInfoService.listUnalyzedWeiboInfo();
        getSemanticByWeiboInfo(weiboInfos);
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
        return EntityUtils.toString(responseEntity);
    }
}
