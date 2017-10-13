package com.xupt.zxh.graduation.project.bean.weibo;

/**
 * 敏感词分析结果
 * Created by 张涛 on 2017/5/28.
 */
public class WeiboSensitive {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 微博ID
     */
    private Integer weiboId;

    /**
     * 敏感词类型
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
