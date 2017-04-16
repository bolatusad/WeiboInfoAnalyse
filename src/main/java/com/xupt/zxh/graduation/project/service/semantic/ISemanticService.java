package com.xupt.zxh.graduation.project.service.semantic;

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
    void getSemantic(List<String> contents) throws IOException;
}
