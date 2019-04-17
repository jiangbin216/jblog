package com.jiang.jblog.vo;

/**
 * 上传图片的响应体
 * FILE: com.jiang.jblog.vo.PhotoResult.java
 * AUTHOR: jiang
 * DATE: 2017/4/21
 * TIME: 22:20
 */
public class PhotoResult {

    private int success;    //成功标准 0失败 1成功
    private String url;     //图片url
    private String message; //错误信息

    public PhotoResult() {
    }

    public PhotoResult(int success, String url, String message) {
        this.success = success;
        this.url = url;
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
