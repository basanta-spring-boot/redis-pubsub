package com.javatechie.consumer;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisSub implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("consumer (1) received message "+message);
    }
}
