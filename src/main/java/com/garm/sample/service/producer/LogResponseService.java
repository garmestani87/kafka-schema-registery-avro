package com.garm.sample.service.producer;

import com.garm.sample.event.LogResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogResponseService {
    public static final String RESPONSE_TOPIC_NAME = "RESPONSE-TOPIC";
    private final KafkaTemplate<String, LogResponse> kafkaTemplate;

    public void sendResponseMessage(LogResponse response) {
        try {
            kafkaTemplate.send(RESPONSE_TOPIC_NAME, response);
        } catch (Exception ex) {
            log.error("Exception ...", ex);
        }
    }
}
