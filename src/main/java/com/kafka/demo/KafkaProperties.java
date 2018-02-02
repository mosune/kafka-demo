package com.kafka.demo;

/**
 * FileName: KafkaProperties
 *
 * @author gcg
 * @create 2018/02/02 15:55
 * Description: 静态变量
 * History:
 **/
public interface KafkaProperties {

    final static String ZHCONNECT = "localhost:2181";
    final static String GROUPID = "group1";
    final static String TOPIC = "topic1";
    final static String KAFKASERVERURL = "localhost";
    final static int KAFKASERVERPORT = 9092;
    final static int KAFAKAPRODUCERBUFFERSIZE = 64 * 1024;
    final static int CONNECTIONTIMEOUT = 20000;
    final static int RECONNECTINTERVAL = 10000;
    final static String TOPIC2 = "topic2";
    final static String TOPIC3 = "topic3";
    final static String CLIENTID = "SimpleConsumerDemoClient";

}
