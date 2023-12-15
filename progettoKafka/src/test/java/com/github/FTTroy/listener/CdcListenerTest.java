package com.github.FTTroy.listener;

import com.github.FTTroy.mapper.EntityMapper;
import com.github.FTTroy.model.input.After;
import com.github.FTTroy.model.input.Before;
import com.github.FTTroy.model.input.InputMessage;
import com.github.FTTroy.model.output.ChiaveRapporto;
import com.github.FTTroy.model.output.CreazioneRapportoValue;
import com.github.FTTroy.model.output.Intestatario;
import com.github.FTTroy.model.output.Testata;
import com.github.FTTroy.model.output.messaggio.MessaggioCreazioneRapporto;
import com.github.FTTroy.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class CdcListenerTest {

    @InjectMocks
    KafkaListener listener;

    @Mock
    InputMessage inputMessage;

    @Mock
    EntityMapper mapper;

    @Mock
    KafkaProducer producer;

    @Test
    public void testOnReceivedInsert() throws IOException {
        when(inputMessage.getAfter()).thenReturn(afterMock(1));
        when(mapper.populateValue(any(),any())).thenReturn(MessaggioCreazioneRapportoMock());
        listener.onReceived(inputMessage);
    }

    @Test
    public void testOnReceivedUpdate() throws IOException {
        when(inputMessage.getAfter()).thenReturn(afterMock(1));
        when(inputMessage.getBefore()).thenReturn(beforeMock(0));

        when(mapper.populateValue(any(),any())).thenReturn(MessaggioCreazioneRapportoMock());
        listener.onReceived(inputMessage);
    }

    @Test
    public void testOnReceivedDelete1() throws IOException {
        when(inputMessage.getAfter()).thenReturn(afterMock(5));
        when(inputMessage.getBefore()).thenReturn(beforeMock(4));
        when(mapper.populateValue(any(),any())).thenReturn(MessaggioCreazioneRapportoMock());
        listener.onReceived(inputMessage);
    }

    @Test
    public void testOnReceivedDelete2() throws IOException {
        when(inputMessage.getAfter()).thenReturn(afterMock(1));
        when(inputMessage.getBefore()).thenReturn(beforeMock(7));
        when(mapper.populateValue(any(),any())).thenReturn(MessaggioCreazioneRapportoMock());
        listener.onReceived(inputMessage);
    }

    private After afterMock(Integer statoRapporto){
        Map<String, Object> map = new HashMap<>();
        map.put("test",statoRapporto);
        Map<String, Map<String, Object>> value = new HashMap<>();
        value.put("STATO_RAPPORTO",map);
        After after = new After();
        after.setValue(value);
        return after;
    }

    private Before beforeMock(Integer statoRapporto){
        Map<String, Object> map = new HashMap<>();
        map.put("test",statoRapporto);
        Map<String, Map<String, Object>> value = new HashMap<>();
        value.put("STATO_RAPPORTO",map);
        Before before = new Before();
        before.setValue(value);
        return before;
    }

    private MessaggioCreazioneRapporto MessaggioCreazioneRapportoMock(){
        return MessaggioCreazioneRapporto.builder().value(valueMock()).build();
    }


    private CreazioneRapportoValue valueMock(){
        return CreazioneRapportoValue.builder()
                .chiaveRapporto(chiaveRapportoMock())
                .testata(testataMock())
                .intestatario(intestatarioMock())
                .codiceTitolo("TEST")
                .durata("TEST")
                .dataInizioVincolo("TEST")
                .dataFineVincolo("TEST")
                .saldoContabile("TEST")
                .build();
    }


    private ChiaveRapporto chiaveRapportoMock(){
        return ChiaveRapporto.builder()
                .abi("TEST")
                .servizio("TEST")
                .categoria("TEST")
                .filiale("TEST")
                .codiceRapporto("TEST")
                .codiceSottorapporto("TEST")
                .build();
    }

    private Testata testataMock(){
        return Testata.builder()
                .idCorrelazione("TEST")
                .tipoEvento("TEST")
                .idEvento("TEST")
                .origine("TEST")
                .timestamp("TEST")
                .build();
    }

    private Intestatario intestatarioMock(){
        return Intestatario.builder()
                .ndg("TEST")
                .abi("TEST")
                .build();
    }


}
