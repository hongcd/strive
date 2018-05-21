package com.hongcd.strive.feign.consumer.web.controller;

import com.hongcd.strive.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/config")
public class ConfigController extends BaseController {
    @Value("${source}")
    private String source;
    @Autowired
    private Environment environment;

    @GetMapping("/getSource")
    public Response<String> getSource() {
        return renderSuccess(source);
    }

    @GetMapping("/getFileName")
    public Response<String> getFileName() {
        return renderSuccess(environment.getProperty("fileName", "未定义"));
    }
}