package com.xupt.zxh.graduation.project.service.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.Sensitive;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboSensitive;

import java.util.List;

/**
 * 敏感词分析相关接口
 * Created by 张涛 on 2017/5/27.
 */
public interface ISensitiveService {

    /**
     * 获取所有的关键词
     * @return
     */
    List<Sensitive> listAllSensitive();

    /**
     * 填充关键词
     */
    void fillKeyWords();

    /**
     * 填充搜索器
     */
    void fillKWSeeker();

    /**
     * 敏感词分析
     * @param weiboInfo
     */
    void sensitiveAnalyse(WeiboInfo weiboInfo);

    /**
     * 获取所有的敏感词分析结果
     */
    List<WeiboSensitive> listAllSensitiveResult();

}
