package com.xupt.zxh.graduation.project.util;

/**
 * Created by admin on 2017/4/3.
 */
public class ResponseInfo {

    public static final String SUCCESS = "001";

    public static final String FAIL = "002";

    private String code = SUCCESS;

    private String desc;

    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
