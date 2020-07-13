package com.yanchuang.dashboardwebsocket.rocketmq.consumer.impl;

import com.yanchuang.dashboardwebsocket.rocketmq.consumer.BaseConsumer;
import com.yanchuang.dashboardwebsocket.websocket.client.NettyWebSocketClient;
import com.yanchuang.dashboardwebsocket.websocket.entity.message.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lonely lee
 * @date 2019/05/16 17:36
 * @since v1.0
 */
@Slf4j
public class MessageConsumer extends BaseConsumer {
    @Autowired
    private NettyWebSocketClient nettyWebSocketClient;

    public MessageConsumer(String topicName) {
        super("messageExample", topicName);
    }

    @Override
    protected void messageBytesHandler(byte[] result) throws Exception {
        String message = SerializationUtils.deserialize(result).toString();
        log.info("消费者已收到消息：" + message);
        /**
         *以下为将消费到的消息以点对点的形式发送到WebSocketServer
         */
        MessageModel messageModel = new MessageModel(message,"group0003","client0001");
        nettyWebSocketClient.sendMessage(messageModel);
    }
}
