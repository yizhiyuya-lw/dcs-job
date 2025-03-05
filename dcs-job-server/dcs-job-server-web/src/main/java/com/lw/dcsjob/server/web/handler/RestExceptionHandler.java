package com.lw.dcsjob.server.web.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.stream.StreamUtil;
import com.lw.dcsjob.common.core.exception.AbstractError;
import com.lw.dcsjob.common.core.exception.BaseDcsJobException;
import com.lw.dcsjob.common.core.exception.DcsJobAuthenticationException;
import com.lw.dcsjob.common.core.model.Result;
import com.lw.dcsjob.common.core.util.StreamUtils;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 统一异常处理
 * @author lw
 * @create 2025-03-04-22:00
 */
@ControllerAdvice(basePackages = {"com.lw.dcsjob.server"})
@Slf4j
@ResponseBody
public class RestExceptionHandler {

    public static final String DELIMITER_TO = "@";
    public static final String DELIMITER_COLON = ":";

    /**
     * 系统异常
     * @param exception
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Result<String> onException(Exception exception) {
        log.error("异常类 onException,", exception);
        return new Result<String>(0, "系统异常");
    }

    /**
     * 业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler({BaseDcsJobException.class})
    public Result<String> onBusinessException(BaseDcsJobException ex) {
        log.error("异常类 businessException", ex);
        if (ex instanceof DcsJobAuthenticationException) {
            DcsJobAuthenticationException authenticationException = (DcsJobAuthenticationException) ex;
            return new Result<String>(authenticationException.getErrorCode(), ex.getMessage());
        }
        return new Result<String>(0, ex.getMessage());
    }

    /**
     * http 400错误
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result<String> requestNotReadable(HttpMessageNotReadableException ex) {
        log.error("异常类 HttpMessageNotReadableException,", ex);
        return new Result<String>(0, AbstractError.PARAM_INCORRECT.toString());
    }

    /**
     * validation异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> onConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if (CollUtil.isNotEmpty(constraintViolations)) {
            String errorMessage = StreamUtils.join(constraintViolations, ConstraintViolation::getMessage, ";");
            return new Result<>(0, errorMessage);
        }
        return new Result<>(0, ex.getMessage());
    }

    /**
     * validation 异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> onMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        if (result != null && result.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> fieldErrors = result.getFieldErrors();
            if (CollUtil.isNotEmpty(fieldErrors)) {
                FieldError fieldError = fieldErrors.get(0);
                String rejectedValue = Objects.toString(fieldError.getRejectedValue(), "");
                String defaultMessage = fieldError.getDefaultMessage();
                //排除类上面的注解提示
                if (rejectedValue.contains(DELIMITER_TO)) {
                    stringBuilder.append(defaultMessage);
                } else {
                    if (DELIMITER_COLON.contains(defaultMessage)) {
                        stringBuilder.append(fieldError.getField()).append(" ").append(defaultMessage);
                    } else {
                        stringBuilder.append(fieldError.getField()).append(" ").append(defaultMessage).append(":").append(rejectedValue);
                    }
                }
            } else {
                String msg = result.getAllErrors().get(0).getDefaultMessage();
                stringBuilder.append(msg);
            }
            return new Result<>(0, stringBuilder.toString());
        }
        return null;
    }

    /**
     * controller参数校验错误
     * @param ex
     * @return
     */
    @ExceptionHandler(HandlerMethodValidationException.class)
    public Result<String> onHandlerMethodValidationException(HandlerMethodValidationException ex) {
        Object[] detailMessageArguments = ex.getDetailMessageArguments();
        if (detailMessageArguments != null && detailMessageArguments.length > 0) {
            return new Result<>(0, detailMessageArguments[0].toString());
        }
        return new Result<>(0, "参数校验失败");
    }

    @ExceptionHandler(TypeMismatchException.class)
    public Result<String> requestTypeMismatch(TypeMismatchException ex) {
        log.error("异常类 TypeMismatchException {}, ", ex.getMessage());
        return new Result<>(0, AbstractError.PARAM_INCORRECT.toString());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result<String> requestMissingServletRequest(MissingServletRequestParameterException ex) {
        log.error("异常类 MissingServletRequestParameterException {},", ex.getMessage());
        return new Result<String>(0, AbstractError.PARAM_INCORRECT.toString());
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public Result<String> request405() {
        log.error("异常类 HttpRequestMethodNotSupportedException ");
        return new Result<String>(0, AbstractError.PARAM_INCORRECT.toString());
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result<String> request415(HttpMediaTypeNotSupportedException ex) {
        log.error("异常类 HttpMediaTypeNotSupportedException {}", ex.getMessage());
        return new Result<String>(0, AbstractError.PARAM_INCORRECT.toString());
    }
}
