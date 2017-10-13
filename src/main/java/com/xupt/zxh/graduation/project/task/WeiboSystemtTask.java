package com.xupt.zxh.graduation.project.task;

import com.xupt.zxh.graduation.project.service.semantic.ISemanticService;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by 张涛 on 2017/5/22.
 */
@Component
public class WeiboSystemtTask {

    @Autowired
    private IWeiboInfoService weiboInfoService;

    @Autowired
    private ISemanticService semanticService;

    /**
     * 爬虫定时任务
     * @throws IOException
     * @throws InterruptedException
     */
//    @Scheduled(cron = "0/30 * *  * * ? ")
//    @Scheduled(cron = "0 0 0 * * ?")
    public void spiderWorkTask() throws IOException, InterruptedException {
        weiboInfoService.spiderWork(weiboInfoService);
    }

    /**
     * 语义分析定时任务
     */
//    @Scheduled(cron = "0 0 2 * * ?")
    public void semanticTask() throws IOException {
        semanticService.setSemantic();
    }


}
