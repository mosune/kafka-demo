package com.kafka.main;

import com.kafka.entity.KafkaProperties;
import com.kafka.producer.KafkaProducer;

/**
 * FileName: ProducerMain
 *
 * @author gcg
 * @create 2018/02/02 16:06
 * Description: main
 * History:
 **/
public class ProducerMain {

    // 启动前需要开启zookeeper服务和指定的kafka服务
    public static void main(String[] args) {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.TOPIC);
        producerThread.start();
    }

}
