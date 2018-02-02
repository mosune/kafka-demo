package com.kafka.demo;

/**
 * FileName: KafkaConsumerProducerDemo
 *
 * @author gcg
 * @create 2018/02/02 16:06
 * Description: demo
 * History:
 **/
public class KafkaConsumerProducerDemo {

    // 启动前需要开启zookeeper服务和指定的kafka服务
    public static void main(String[] args) {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.TOPIC);
        producerThread.start();
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.TOPIC);
        consumerThread.start();
    }

}
