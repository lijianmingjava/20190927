package com.lanxin.util;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyException {


    @ExceptionHandler(value = {Exception.class})
    Object handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg","没有权限");
        map.put("url", request.getRequestURL());
        return map;
    }
}
