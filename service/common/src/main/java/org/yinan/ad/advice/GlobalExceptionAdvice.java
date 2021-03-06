package org.yinan.ad.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.yinan.ad.exception.AdException;
import org.yinan.ad.vo.CommonResponse;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionAdvice {
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req, AdException ex) {
        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
