package com.yanchuang.dashboardwebsocket.websocket.enable;

import com.yanchuang.dashboardwebsocket.websocket.properties.WebSocketProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lonely lee
 * @date 2019/05/15 17:22
 * @since v1.0
 */
@Configuration
@ComponentScan("com.yanchuang.dashboardwebsocket.websocket")
@EnableConfigurationProperties(value = WebSocketProperties.class)
public class WebSocketStarterConfigure {
}
