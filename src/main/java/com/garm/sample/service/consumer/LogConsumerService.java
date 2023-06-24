package com.garm.sample.service.consumer;

import com.garm.sample.event.LogRequest;
import com.garm.sample.event.LogResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogConsumerService {

    @KafkaListener(topics = "REQUEST-TOPIC", groupId = "garm", containerFactory = "kafkaListenerContainerFactory")
    public void consumeRequest(@Payload final LogRequest request) {
        //implement your business here
    }

    @KafkaListener(topics = "RESPONSE-TOPIC", containerFactory = "kafkaListenerContainerFactory")
    public void consumeResponse(@Payload final LogResponse response) {
        //implement your business here
    }
}