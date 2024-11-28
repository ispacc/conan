package io.origins.conancommon.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultData<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(0, "success", data);
    }

    public static <T> ResultData<T> fail(int code, String message) {
        return new ResultData<>(code, message, null);
    }
}
