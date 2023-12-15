package com.github.FTTroy.producer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class CdcProducerTest {


    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Mock
    private Logger logger;

    @InjectMocks
    private KafkaProducer cdcProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendMessageTest() {
        String key = "testKey";
        Object message = "testMessage";
        cdcProducer.sendMessage(message, key);
    }
}
