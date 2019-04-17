package com.jiang.jblog.util;

import com.jiang.jblog.vo.UserInfo;

/**
 * 获取错误信息的工具类
 * FILE: com.jiang.jblog.util.UserInfoUtil.java
 * AUTHOR: jiang
 * DATE: 2017/4/9
 * TIME: 15:39
 */
public class ResultInfoFactory {
    public static com.jiang.jblog.util.ResultInfo ERROR_RESULT ;
    public static com.jiang.jblog.util.ResultInfo SUCCESS_RESULT;

    /**
     * 带错误信息错误信息相应体
     * @param errorInfo
     * @return
     */
    public static com.jiang.jblog.util.ResultInfo getErrorResultInfo(String errorInfo){
        if (ERROR_RESULT == null){
            ERROR_RESULT = new com.jiang.jblog.util.ResultInfo("fail",errorInfo);
        }else{
            ERROR_RESULT.setErrorInfo(errorInfo);
        }
        return ERROR_RESULT;
    }

    /**
     * 不带参数错误信息相应体
     * 默认为错误信息为操作失败
     * @return
     */
    public static com.jiang.jblog.util.ResultInfo getErrorResultInfo(){
        return getErrorResultInfo("操作失败！！！");
    }

    /**
     * 带参数正确的实体相应题
     * @param errorInfo
     * @return
     */
    public static com.jiang.jblog.util.ResultInfo getSuccessResultInfo(String errorInfo){
        if (SUCCESS_RESULT == null){
            SUCCESS_RESULT = new com.jiang.jblog.util.ResultInfo("success",errorInfo);
        }else{
            SUCCESS_RESULT.setErrorInfo(errorInfo);
        }
        return SUCCESS_RESULT;
    }

    /**
     * 不带参数正确的信息相应体
     * 默认为错误信息为操作成功
     * @return
     */
    public static com.jiang.jblog.util.ResultInfo getSuccessResultInfo(){
        return getSuccessResultInfo("操作成功！！！");
    }


    public static com.jiang.jblog.util.ResultInfo getSuccessData(UserInfo userInfo) {
        com.jiang.jblog.util.ResultInfo successResultInfo = getSuccessResultInfo();
        successResultInfo.setObject(userInfo);
        return successResultInfo;
    }


}
