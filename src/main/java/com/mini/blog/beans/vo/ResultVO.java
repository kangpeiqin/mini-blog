package com.mini.blog.beans.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVo = new ResultVO<>();
        resultVo.setCode(HttpStatus.OK.value());
        resultVo.setMsg(HttpStatus.OK.getReasonPhrase());
        resultVo.setData(data);
        return resultVo;
    }
}
