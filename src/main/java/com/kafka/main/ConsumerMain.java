package com.kafka.main;

import com.kafka.consumer.KafkaConsumer;
import com.kafka.entity.KafkaProperties;

/**
 * FileName: ConsumerMain
 *
 * @author gcg
 * @create 2018/02/05 10:00
 * Description:
 * History:
 **/
public class ConsumerMain {

    public static void main(String[] args) {
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.TOPIC, "comsumer1");
        consumerThread.start();
    }

}
