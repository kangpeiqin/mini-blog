package com.mini.blog.beans.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@ApiModel("相应结果")
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("提示信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;

    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVo = new ResultVO<>();
        resultVo.setCode(HttpStatus.OK.value());
        resultVo.setMsg(HttpStatus.OK.getReasonPhrase());
        resultVo.setData(data);
        return resultVo;
    }

    public static <T> ResultVO<T> error(Integer code, String msg) {
        return new ResultVO<>(code, msg, null);
    }

}
