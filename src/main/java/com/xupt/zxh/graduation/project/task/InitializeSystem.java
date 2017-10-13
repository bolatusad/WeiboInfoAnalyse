package com.xupt.zxh.graduation.project.task;

import com.xupt.zxh.graduation.project.service.weibo.ISensitiveService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 初始化项目，用于执行一些初始化任务
 * 教程链接：http://blog.csdn.net/liuyifeng1920/article/details/49800537
 * Created by 张涛 on 2017/5/27.
 */
@Component
public class InitializeSystem implements InitializingBean {

    @Autowired
    private ISensitiveService sensitiveService;

    @Override
    public void afterPropertiesSet() throws Exception {
        sensitiveService.fillKeyWords();
    }

}
