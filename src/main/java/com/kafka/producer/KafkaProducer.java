package com.kafka.producer;

import com.alibaba.fastjson.JSONObject;
import com.kafka.entity.Message;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Map;
import java.util.Properties;

/**
 * FileName: KafkaProducer
 *
 * @author gcg
 * @create 2018/02/02 15:58
 * Description: producer
 * History:
 **/
public class KafkaProducer extends Thread {

    private final Producer<Integer, String> producer;
    private final String topic;
    private final Properties props = new Properties();

    public KafkaProducer(String topic) {
        props.put("serializer.class", "kafka.serializer.StringEncoder"); // 设置序列化为String
        props.put("metadata.broker.list", "127.0.0.1:9092"); // kafka的服务地址
        producer = new Producer<Integer, String>(new ProducerConfig(props)); // 设置producer的配置
        this.topic = topic; // 设置topic名称
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true) {
            /**
             * 发送消息
             */
            /*String messageStr = new String("Message_" + messageNo);
            System.out.println("Send:" + messageStr);
            producer.send(new KeyedMessage<Integer, String>(topic, messageStr)); // 设置发送的消息*/
            Message message = Message.builder().name("name" + messageNo).content("content" + messageNo).build();
            JSONObject json = new JSONObject();
            json.put("message", message);
            System.out.println(message.toString());
            producer.send(new KeyedMessage<Integer, String>(topic, json.toJSONString()));
            messageNo++;
            try {
                sleep(1000); // 一秒发送一次消息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
