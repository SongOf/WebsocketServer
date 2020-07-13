package com.yanchuang.dashboardwebsocket.rocketmq.config;


import com.yanchuang.dashboardwebsocket.rocketmq.consumer.impl.MessageConsumer;
import com.yanchuang.dashboardwebsocket.rocketmq.producer.impl.MessageProducer;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "rocketmq")
public class RocketMQConfigure {

    private String mqAddress;
    private String topicName;
    private String tagName;

//    @Bean(initMethod = "startProducerClient")
//    public MessageProducer messageProducer(){
//        MessageProducer messageProducer = new MessageProducer(topicName,tagName);
//        messageProducer.setMqAddress(mqAddress);
//        return messageProducer;
//    }

    @Bean(initMethod = "startConsumerClient")
    public MessageConsumer messageConsumer(){
        MessageConsumer messageConsumer = new MessageConsumer(topicName);
        messageConsumer.setMqAddress(mqAddress);
        return messageConsumer;
    }
}
