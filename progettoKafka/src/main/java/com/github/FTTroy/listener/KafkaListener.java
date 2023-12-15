package com.github.FTTroy.listener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.FTTroy.model.input.InputMessage;
import com.github.FTTroy.model.output.messaggio.MessaggioCreazioneRapporto;
import com.github.FTTroy.model.output.messaggio.MessaggioEstinzioneRapporto;
import com.github.FTTroy.producer.KafkaProducer;
import com.github.FTTroy.mapper.EntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class KafkaListener {

    private final Logger logger = LoggerFactory.getLogger(KafkaListener.class);

    @Autowired
    KafkaProducer producer;


    private EntityMapper entityMapper = new EntityMapper();

    ObjectMapper mapper = new ObjectMapper();

    @org.springframework.kafka.annotation.KafkaListener(topics = "${topic.input}", groupId = "groupId")
    public void onReceived(@Payload InputMessage message) throws IOException {
        try {
            logger.info("INIZIO - ELABORAZIONE MESSAGGIO: " + message.toString());
            String tipoEvento = "";
            Integer beforeStatoRapporto = null;
            Object outputMessage = null;
            JsonNode beforeNode = null;
            JsonNode afterNode = mapper.valueToTree(message.getAfter().getValue());
             Integer afterStatoRapporto = afterNode.findValue("STATO_RAPPORTO").fields().next().getValue().asInt();

            if (message.getBefore() != null) {
                beforeNode = mapper.valueToTree(message.getBefore().getValue());
                beforeStatoRapporto = beforeNode.findValue("STATO_RAPPORTO").fields().next().getValue().asInt();
                if (isUpdate(beforeStatoRapporto, afterStatoRapporto)) {
                    tipoEvento = "RAPPORTO_CREATO";
                    outputMessage = (MessaggioCreazioneRapporto) entityMapper.populateValue(afterNode, tipoEvento);
                } else if (isDelete(beforeStatoRapporto, afterStatoRapporto)) {
                    tipoEvento = "RAPPORTO_ESTINTO";
                    outputMessage = (MessaggioEstinzioneRapporto) entityMapper.populateValue(beforeNode, tipoEvento);
                }
            } else if (afterStatoRapporto == 1) {
                tipoEvento = "RAPPORTO_CREATO";
                outputMessage = (MessaggioCreazioneRapporto) entityMapper.populateValue(afterNode, tipoEvento);
            }
            logger.info("FINE - ELABORAZIONE MESSAGGIO: " + outputMessage);

            String key = entityMapper.generateKey(entityMapper.chiaveRapportoMapper(afterNode));
            producer.sendMessage(outputMessage, key);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private boolean isUpdate(Integer beforeStatoRapporto, Integer afterStatoRapporto) {
        return (beforeStatoRapporto == 0 && afterStatoRapporto == 1);
    }

    private boolean isDelete(Integer beforeStatoRapporto, Integer afterStatoRapporto) {
        return (beforeStatoRapporto == 4 && afterStatoRapporto == 5)
                || (beforeStatoRapporto == 1 && afterStatoRapporto == 7);
    }

}