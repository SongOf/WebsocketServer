package com.yanchuang.dashboardwebsocket;

import com.yanchuang.dashboardwebsocket.websocket.enable.EnableWebSocketClient;
import com.yanchuang.dashboardwebsocket.websocket.enable.EnableWebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lonely lee
 * @date 2019/05/15 10:52
 * @since v1.0
 */
@EnableWebSocketServer
@EnableWebSocketClient
@SpringBootApplication
public class WebsocketServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketServerApplication.class,args);
    }
}
