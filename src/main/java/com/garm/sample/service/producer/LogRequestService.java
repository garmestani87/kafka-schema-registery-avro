package com.garm.sample.service.producer;

import com.garm.sample.event.LogRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogRequestService {
    public static final String REQUEST_TOPIC_MAME = "REQUEST-TOPIC";
    private final KafkaTemplate<String, LogRequest> kafkaTemplate;


    public void sendRequestMessage(LogRequest request) {
        try {
            this.kafkaTemplate.send(REQUEST_TOPIC_MAME, request);
        } catch (Exception ex) {
            log.error("Exception ...", ex);
        }
    }
}
