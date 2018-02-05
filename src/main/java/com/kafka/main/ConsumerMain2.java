package com.kafka.main;

import com.kafka.consumer.KafkaConsumer;
import com.kafka.entity.KafkaProperties;

/**
 * FileName: ConsumerMain2
 *
 * @author gcg
 * @create 2018/02/05 9:56
 * Description:
 * History:
 **/
public class ConsumerMain2 {

    public static void main(String[] args) {
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.TOPIC, "comsumer2");
        consumerThread.start();
    }

}
