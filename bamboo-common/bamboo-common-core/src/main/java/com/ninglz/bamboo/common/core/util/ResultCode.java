package com.ninglz.bamboo.common.core.util;


import lombok.*;

/**
 * 统一API响应返回码
 * @author ninglz 2018-03-06
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Getter
public class ResultCode {
    public final static ResultCode SUCCESS = new ResultCode(200,"接口调用成功");
    public final static ResultCode BIND_INVALID = new ResultCode(400,"请求参数错误");
    public final static ResultCode UNAUTHORIZED = new ResultCode(401,"未经授权");
    public final static ResultCode UNDEFINED = new ResultCode(99999,"UNDEFINED");

    private int code;

    private String message;

}

