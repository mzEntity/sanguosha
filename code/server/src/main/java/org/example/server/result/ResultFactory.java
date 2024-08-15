package org.example.server.result;

public class ResultFactory {

    private static String defaultSuccessMsg = "成功";
    private static String defaultFailMsg = "失败";
    private static String defaultUnauthorizedMsg = "没有权限";
    private static String defaultNotFoundMsg = "缺失";
    private static String defaultInternalServerErrorMsg = "服务器错误";
    public static Result buildResult(ResultCode code, String msg, Object object){
        return new Result(code.getCode(), msg, object);
    }

    public static Result buildSuccessResult(Object object, String msg){
        return buildResult(ResultCode.SUCCESS, msg, object);
    }

    public static Result buildFailResult(Object object, String msg){
        return buildResult(ResultCode.FAIL, msg, object);
    }

    public static Result buildUnauthorizedResult(Object object, String msg){
        return buildResult(ResultCode.UNAUTHORIZED, msg, object);
    }

    public static Result buildNotFoundResult(Object object, String msg){
        return buildResult(ResultCode.NOT_FOUND, msg, object);
    }

    public static Result buildInternalServerErrorResult(Object object, String msg){
        return buildResult(ResultCode.INTERNAL_SERVER_ERROR, msg, object);
    }

    public static Result buildSuccessResult(Object object){
        return buildSuccessResult(object, defaultSuccessMsg);
    }

    public static Result buildFailResult(Object object){
        return buildFailResult(object, defaultFailMsg);
    }

    public static Result buildUnauthorizedResult(Object object){
        return buildUnauthorizedResult(object, defaultUnauthorizedMsg);
    }

    public static Result buildNotFoundResult(Object object){
        return buildNotFoundResult(object, defaultNotFoundMsg);
    }

    public static Result buildInternalServerErrorResult(Object object){
        return buildInternalServerErrorResult(object, defaultInternalServerErrorMsg);
    }
}
