package com.hongcd.strive.consumer.web.controller;

import com.hongcd.strive.common.constant.Config;
import com.hongcd.strive.common.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected Config config;

    protected Response renderSuccess(Object data) {
        return render(Response.SUCCESS, data);
    }

    protected Response renderFail(String message) {
        return render(Response.FAIL, message, null);
    }

    protected Response render(int code,  Object data) {
        return render(code, null, data);
    }

    protected Response render(int code, String message, Object data) {
        return new Response(code, message, data).setServerInfo(config.getServerName(), config.getServerPort());
    }

    protected Response render(Response response) {
        return response.setServerInfo(config.getServerName(), config.getServerPort());
    }
}