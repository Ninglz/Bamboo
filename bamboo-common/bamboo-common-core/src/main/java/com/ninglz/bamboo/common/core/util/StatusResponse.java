//package com.ninglz.bamboo.common.core.util;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//
///**
// * @program: common
// * @description: 状态响应类
// * @author: ninglz
// * @eamil: ninglz@yeah.net
// * @created: 2021/07/21 11:44
// */
//@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
//@NoArgsConstructor
//@ApiModel(value = "状态响应主体")
//public class StatusResponse implements Serializable {
//
//    @SerializedName("c")
//    @JsonProperty("c")
//    @Getter
//    @ApiModelProperty(value = "返回标记：成功标记=200")
//    private int code;
//
//    @SerializedName( "m")
//    @JsonProperty("m")
//    @ApiModelProperty(value = "成功/失败信息")
//    private String message;
//
//    @SerializedName("d")
//    @JsonProperty("d")
//    @ApiModelProperty(value = "数据")
//    private Object data;
//
//
//    private static final StatusResponse EMPTY_SUCCESS = of(ResultCode.SUCCESSFUL, null, null);
//    private static final StatusResponse ERR_UNDEFINED = of(ResultCode.UNDEFINDED, null, null);
//
//    public static StatusResponse of(
//            ResultCode resultCode,
//            String message,
//            Object data) {
//        return new StatusResponse(resultCode.getCode(), message, data);
//    }
//
//    public static StatusResponse success() {
//        return EMPTY_SUCCESS;
//    }
//
//    public static StatusResponse undefined() {
//        return ERR_UNDEFINED;
//    }
//
//    public static StatusResponse error(ResultCode code) {
//        return of(code, code.getMessage(), null);
//    }
//    public static StatusResponse error(ResultCode code, String message) {
//        return of(code, message, null);
//    }
//
//    public static StatusResponse success(Object data) {
//        return of(ResultCode.SUCCESSFUL, null, data);
//    }
//
//    public static StatusResponse success(String message, Object data) {
//        return of(ResultCode.SUCCESSFUL, message, data);
//    }
//
//    public static class error extends Throwable {
//        public error(ResultCode bindInvalid) {
//        }
//    }
//}
