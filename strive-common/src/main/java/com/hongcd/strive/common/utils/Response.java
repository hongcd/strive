package com.hongcd.strive.common.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
public class Response implements Serializable {
    public static int SUCCESS = 1;
    public static int FAIL = 0;

    private Integer code;
    private String message;
    private Object data;
    private int invokeCount;
    private List<ServerInfo> serverInfoLinks = new LinkedList<>();

    public Response() {}
    public Response(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
    public Response(Integer code, String message, Object data) {
        this(code, data);
        this.message = message;
    }

    public Response setServerInfo(String serverName, Integer serverPort) {
        serverInfoLinks.add(new ServerInfo(serverName, serverPort, ++invokeCount));
        return this;
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