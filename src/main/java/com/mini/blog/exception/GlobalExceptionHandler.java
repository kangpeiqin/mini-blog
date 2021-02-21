package com.mini.blog.exception;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.mini.blog.model.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public ResultVO maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e) {
        log.error("文件大小不能超过1MB", e);
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "文件大小不能超过1MB");
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public ResultVO dataAccessExceptionHandler(DataAccessException e) {
        log.error("服务器内部错误：数据库操作异常", e);
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "数据库操作异常");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVO missingServletRequestParameterExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException e) {
        log.error("参数缺失异常", e);
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResultVO illegalArgumentExceptionHandler(HttpServletRequest request, IllegalArgumentException e) {
        log.error("非法参数异常", e);
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(MybatisPlusException.class)
    @ResponseBody
    public ResultVO mybatisPlusExceptionHandler(HttpServletRequest request, MybatisPlusException e) {
        log.error("非法参数异常", e);
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVO validException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("参数校验异常", e);
        StringBuilder errorMsgBuilder = new StringBuilder();
        e.getBindingResult().getAllErrors().stream().forEach(objectError -> errorMsgBuilder.append(objectError.getDefaultMessage()).append(System.lineSeparator()));
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "操作失败:" + errorMsgBuilder.toString());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("未知错误", e);
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知错误");
    }
}
