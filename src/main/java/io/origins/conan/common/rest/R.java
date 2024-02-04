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
public class R<T> {

    private int code;
    private String message;
    private T data;


    public static <T> R<T> success(T data) {
        return new R<>(200, "操作成功", data);
    }

    public static <T> R<T> success(String message, T data) {
        return new R<>(200, message, data);
    }

    public static <T> R<T> fail(String message) {
        return new R<>(400, message, null);
    }

}
