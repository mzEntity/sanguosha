package org.example.server.result;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200, "SUCCESS"),
    FAIL(400, "FAIL"),
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR");

    private int code;
    private String name;

    ResultCode(int code, String name){
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ResultCode(" + this.code + ", " + this.name + ")";
    }
}
