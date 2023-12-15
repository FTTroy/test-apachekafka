package com.github.FTTroy.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${topic.output}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Object message, String key){
        logger.info("INIZIO - INVIO MESSAGGIO\n "+"MESSAGE:"+message+"\n KEY:"+key+ "\nTOPIC: "+TOPIC);
        kafkaTemplate.send(TOPIC,key,message);
        logger.info("MESSAGGIO INVIATO - CORRETTAMENTE");
    }
}
