package io.origins.conan.common.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestResp<T> {

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;


    public static <T> RestResp<T> success(T data) {
        return new RestResp<>(200, "操作成功", data);
    }

    public static <T> RestResp<T> success(String message, T data) {
        return new RestResp<>(200, message, data);
    }

    public static <T> RestResp<T> fail(String message) {
        return new RestResp<>(400, message, null);
    }

}
