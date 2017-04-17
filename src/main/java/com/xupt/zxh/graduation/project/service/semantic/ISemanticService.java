package com.xupt.zxh.graduation.project.service.semantic;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboEmotion;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;

import java.io.IOException;
import java.util.List;

/**
 * 语义分析服务类
 * Created by admin on 2017/4/6.
 */
public interface ISemanticService {

    /**
     * 获取语义分析
     * @param contents
     */
    List<WeiboEmotion> getSemantic(List<String> contents) throws IOException;

    /**
     * 通过WeiboInfo 获取相应的情感分析，并放入数据库
     * @param weiboInfos
     */
    void getSemanticByWeiboInfo(List<WeiboInfo> weiboInfos) throws IOException;

    /**
     * 获取最没有被分析的微博
     */
    void setSemantic() throws IOException;
}
