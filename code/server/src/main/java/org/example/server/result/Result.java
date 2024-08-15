package org.example.server.result;

import lombok.Getter;

@Getter
public class Result {
    private int code;
    private String msg;
    private Object object;

    public Result(int code, String msg, Object object){
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
