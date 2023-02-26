package com.javatechie.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.dto.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RedisPub {

    private StringRedisTemplate template;

    private ChannelTopic channelTopic;

    @PostMapping("/publish")
    public String publish(@RequestBody Student student) throws JsonProcessingException {
        template.convertAndSend(channelTopic.getTopic(), new ObjectMapper().writeValueAsString(student));
        return "Event published !!";
    }


}
