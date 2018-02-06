package com.kafka.entity;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * FileName: Message
 *
 * @author gcg
 * @create 2018/02/05 10:34
 * Description:
 * History:
 **/
@Data
@Builder
public class Message implements Serializable {

    private String name;

    private String content;

}
