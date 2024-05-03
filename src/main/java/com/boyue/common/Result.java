package com.boyue.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public static Result ok() {
        Result result = new Result();
        result.setCode(200);
        return result;
    }

    public static <T> Result ok(T data) {
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        return result;
    }
}
