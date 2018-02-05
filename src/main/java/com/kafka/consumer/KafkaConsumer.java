package com.kafka.consumer;

import com.kafka.entity.KafkaProperties;
import com.kafka.entity.Message;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * FileName: KafkaConsumer
 *
 * @author gcg
 * @create 2018/02/02 16:02
 * Description: consumer
 * History:
 **/
public class KafkaConsumer extends Thread {

    private final ConsumerConnector consumer; // consumer连接
    private final String topic;
    private String name;

    public KafkaConsumer(String topic, String name) {
        consumer = Consumer.createJavaConsumerConnector(createConsumerConfig());
        this.topic = topic;
        this.name = name;
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaProperties.ZHCONNECT); // zookeeper地址
        props.put("group.id", KafkaProperties.GROUPID); // consumer的所在组
        props.put("zookeeper.session.timeout.ms", "40000"); // zookeeper中间隔时间超时
        props.put("zookeeper.sync.time.ms", "200"); // follow可以落后leader时间
        props.put("auto.commit.interval.ms", "1000"); //自动更新时间
        return new ConsumerConfig(props);
    }

    @Override
    public void run() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>(); // 只有一个topic
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap); // 接收消息。key是topic名，value是消息
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator(); // 获取迭代对象
        while (it.hasNext()) {
            // System.out.println("name: " + name + "receive：" + new String(it.next().message()));
            System.out.println(it.next().message().toString());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
