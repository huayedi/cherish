package com.jxhx.cherish.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/***
 * 全局异常处理类
 * @author zsj
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 抓取CherishException异常
     * @param req request
     * @param e 异常
     * @return 全局异常类
     * @throws Exception
     */
    @ExceptionHandler(value = CherishException.class)
    @ResponseBody
    public CherishExceptionUtil<String> jsonErrorHandler(HttpServletRequest req, CherishException e) throws Exception {
        CherishExceptionUtil<String> cherishExceptionUtil = new CherishExceptionUtil<>();
        cherishExceptionUtil.setMsg(e.getMessage());
        cherishExceptionUtil.setCode(CherishExceptionUtil.ERROR);
        cherishExceptionUtil.setData("处理错误");
        cherishExceptionUtil.setUrl(req.getRequestURL().toString());
        return cherishExceptionUtil;
    }

}
