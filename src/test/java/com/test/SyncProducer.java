package com.test;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

@Slf4j
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new
                DefaultMQProducer("messageExample");
        producer.setNamesrvAddr("123.56.46.27:9876");
        producer.setCreateTopicKey("TestMessage");
        producer.setRetryTimesWhenSendFailed(2);
        producer.start();
        JSONObject jsonContent= new JSONObject();
        jsonContent.put("key","totalPerMonth");
        jsonContent.put("value",56);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content",jsonContent);
        jsonObject.put("sendTime",System.currentTimeMillis());
        jsonObject.put("spreadType","POINT");
        jsonObject.put("groupId","group0003");
        jsonObject.put("clientId","client0001");
        jsonObject.put("sendClientId","client0001");
        for (int i = 0; i < 1; i++) {
            log.info(JSONObject.toJSONString(jsonObject));
            byte[] messageBytes  = SerializationUtils.serialize(JSONObject.toJSONString(jsonObject));
            Message message = new Message("TestMessage","TagA",messageBytes);
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
