package com.hongcd.strive.provider.aop;

import com.hongcd.strive.common.constant.Config;
import com.hongcd.strive.common.exception.BusinessException;
import com.hongcd.strive.common.utils.Response;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Log4j
@Aspect
@Component
public class ControllerAspect {
    @Autowired
    private Config config;

    @Pointcut("execution(public com.hongcd.strive.common.utils.Response com.hongcd.strive.provider.web.controller.*.*(..)) && (" +
            "@annotation(org.springframework.web.bind.annotation.RequestMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PatchMapping))")
    public void controller() {}

    @Around("controller()")
    public Response throwsExceptionAfterEditResponse(ProceedingJoinPoint joinPoint) {
        Response response = null;
        try {
            response = (Response) joinPoint.proceed();
        } catch (Throwable throwable) {
            if (throwable instanceof BusinessException) {
                log.error(throwable.getMessage());
            } else {
                log.error(String.format("Fail to %s, msg: %s", joinPoint.getTarget().getClass().getName() + ((MethodSignature) joinPoint.getSignature()).getMethod().getName(), throwable.getMessage()), throwable);
            }
            response = new Response(Response.FAIL, throwable.getMessage(), null);
        } finally {
            Objects.requireNonNull(response).setServerInfo(config.getServerName(), config.getServerPort());
        }
        return response;
    }
}