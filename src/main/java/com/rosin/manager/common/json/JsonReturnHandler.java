package com.rosin.manager.common.json;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/2/15.
 */
public class JsonReturnHandler implements HandlerMethodReturnValueHandler,BeanPostProcessor {
    private static Logger logger = Logger.getLogger(JsonReturnHandler.class);
    List<ResponseBodyAdvice<Object>> advices = new ArrayList<ResponseBodyAdvice<Object>>();

    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        logger.info("JsonReturnHandler"+"--"+"postProcessBeforeInitialization"+"--");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        logger.info("JsonReturnHandler"+"--"+"postProcessAfterInitialization"+"--");
        if (bean instanceof ResponseBodyAdvice) {
            advices.add((ResponseBodyAdvice<Object>) bean);
        } else if (bean instanceof RequestMappingHandlerAdapter) {
            List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>(
                    ((RequestMappingHandlerAdapter) bean).getReturnValueHandlers());
            JsonReturnHandler jsonHandler = null;
            for (int i = 0; i < handlers.size(); i++) {
                HandlerMethodReturnValueHandler handler = handlers.get(i);
                if (handler instanceof JsonReturnHandler) {
                    jsonHandler = (JsonReturnHandler) handler;
                    break;
                }
            }
            if (jsonHandler != null) {
                handlers.remove(jsonHandler);
                handlers.add(0, jsonHandler);
                ((RequestMappingHandlerAdapter) bean).setReturnValueHandlers(handlers); // change the jsonhandler sort
            }
        }
        return bean;
    }

    public boolean supportsReturnType(MethodParameter methodParameter) {
        boolean hasJSONAnno = methodParameter.getMethodAnnotation(JSON.class) != null;
        logger.info("JsonReturnHandler"+"--"+"supportsReturnType"+"--hasJSONAnno"+hasJSONAnno);
        return hasJSONAnno;
    }

    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        mavContainer.setRequestHandled(true);
        for (int i=0;i<advices.size();i++){
            ResponseBodyAdvice<Object> ad = advices.get(i);
            if (ad.supports(returnType, null)) {
                returnValue = ad.beforeBodyWrite(returnValue, returnType, MediaType.APPLICATION_JSON_UTF8, null,
                        new ServletServerHttpRequest(webRequest.getNativeRequest(HttpServletRequest.class)),
                        new ServletServerHttpResponse(webRequest.getNativeResponse(HttpServletResponse.class)));
            }
        }

        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        Annotation[] annos = returnType.getMethodAnnotations();
        CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
        for (Annotation anno:annos) {
            if (anno instanceof JSON) {
                JSON json = (JSON) anno;
                jsonSerializer.filter(json);
            }
        }
        logger.info("JsonReturnHandler"+"--"+"handleReturnValue"+"--");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        String json = jsonSerializer.toJson(returnValue);
        response.getWriter().write(json);
    }

//    @Override
//    public boolean supportsReturnType(MethodParameter returnType) {
//        boolean hasJSONAnno = returnType.getMethodAnnotation(JSON.class) != null;
//        return hasJSONAnno;
//    }
//
//    @Override
//    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
//                                  NativeWebRequest webRequest) throws Exception {
//        mavContainer.setRequestHandled(true);
//        for (int i=0;i<advices.size();i++){
//            ResponseBodyAdvice<Object> ad = advices.get(i);
//            if (ad.supports(returnType, null)) {
//                returnValue = ad.beforeBodyWrite(returnValue, returnType, MediaType.APPLICATION_JSON_UTF8, null,
//                        new ServletServerHttpRequest(webRequest.getNativeRequest(HttpServletRequest.class)),
//                        new ServletServerHttpResponse(webRequest.getNativeResponse(HttpServletResponse.class)));
//            }
//        }
//
//        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
//        Annotation[] annos = returnType.getMethodAnnotations();
//        CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
//        for (Annotation anno:annos) {
//            if (anno instanceof JSON) {
//                JSON json = (JSON) anno;
//                jsonSerializer.filter(json);
//            }
//        }
//
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//        String json = jsonSerializer.toJson(returnValue);
//        response.getWriter().write(json);
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof ResponseBodyAdvice) {
//            advices.add((ResponseBodyAdvice<Object>) bean);
//        } else if (bean instanceof RequestMappingHandlerAdapter) {
//            List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>(
//                    ((RequestMappingHandlerAdapter) bean).getReturnValueHandlers());
//            JsonReturnHandler jsonHandler = null;
//            for (int i = 0; i < handlers.size(); i++) {
//                HandlerMethodReturnValueHandler handler = handlers.get(i);
//                if (handler instanceof JsonReturnHandler) {
//                    jsonHandler = (JsonReturnHandler) handler;
//                    break;
//                }
//            }
//            if (jsonHandler != null) {
//                handlers.remove(jsonHandler);
//                handlers.add(0, jsonHandler);
//                ((RequestMappingHandlerAdapter) bean).setReturnValueHandlers(handlers); // change the jsonhandler sort
//            }
//        }
//        return bean;
//    }

}
