package com.hongcd.strive.common.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 响应对象
 * @author HongD
 * @date 2018-10-12
 */
@Data
public class Response<T> implements Serializable {
    public static int SUCCESS = 1;
    public static int FAIL = 0;

    private Integer code;
    private String msg;
    private T data;
    private int invokeCount;
    private List<ServerInfo> serverInfoLinks = new LinkedList<>();

    public Response() {}
    public Response(Integer code, T data) {
        this.code = code;
        this.data = data;
    }
    public Response(Integer code, String msg, T data) {
        this(code, data);
        this.msg = msg;
    }

    /**
     * 返回成功响应-带消息
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(String msg, T data) {
        return new Response<>(SUCCESS, msg, data);
    }

    /**
     * 返回成功响应
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T data) {
        return success(null, data);
    }

    /**
     * 返回错误响应with错误码
     * @param code
     * @param msg
     * @return
     */
    public static Response<?> fail(int code, String msg) {
        return new Response<>(code, msg);
    }

    /**
     * 返回错误响应
     * @param msg
     * @return
     */
    public static Response<?> fail(String msg) {
        return fail(FAIL, msg);
    }

    public void setServerInfo(String serverName, Integer serverPort) {
        serverInfoLinks.add(new ServerInfo(serverName, serverPort, ++invokeCount));
    }

    @Data
    public static class ServerInfo {
        private String serverName;
        private Integer serverPort;
        private int order;

        public ServerInfo() {}
        public ServerInfo(String serverName, Integer serverPort, int order) {
            this.serverName = serverName;
            this.serverPort = serverPort;
            this.order = order;
        }
    }
}