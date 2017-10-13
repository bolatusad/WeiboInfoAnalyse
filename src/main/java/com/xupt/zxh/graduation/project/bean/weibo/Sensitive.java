package com.xupt.zxh.graduation.project.bean.weibo;

/**
 * 敏感词
 * Created by 张涛 on 2017/5/27.
 */
public class Sensitive {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 敏感词内容
     */
    private String content;

    /**
     * 敏感词类型：1：武器；2：色情
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
