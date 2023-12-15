package com.github.FTTroy.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.FTTroy.model.input.After;
import com.github.FTTroy.model.output.ChiaveRapporto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

public class EntityMapperTest {


    @Test
    public void populateValueCreazioneRapportoTest() {
        EntityMapper mapper = new EntityMapper();
        mapper.populateValue(jsonNodeMock(), "RAPPORTO_CREATO");
    }

    @Test
    public void populateValueEstinzioneRapportoTest() {
        EntityMapper mapper = new EntityMapper();
        mapper.populateValue(jsonNodeMock(), "RAPPORTO_ESTINTO");
        mapper.generateKey(chiaveRapportoMock());
    }

    private JsonNode jsonNodeMock() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.valueToTree(mockAfter());
    }

    private Map<String, Map<String, Object>> mockMap(){
        Map<String,Map<String,Object>> map = new HashMap<>();
        Map<String,Object> nestedMap = new HashMap<>();
        nestedMap.put("int",1);
        map.put("ABI",nestedMap);
        map.put("SERVIZIO",nestedMap);
        map.put("CATEGORIA",nestedMap);
        map.put("FILIALE",nestedMap);
        map.put("CODICE_RAPPORTO",nestedMap);
        map.put("CODICE_SOTTORAPPORTO",nestedMap);
        map.put("NDG",nestedMap);
        map.put("SALDO_CONTABILE",nestedMap);
        map.put("DURATA",nestedMap);
        map.put("DATA_INIZIO_VINCOLO",nestedMap);
        map.put("DATA_FINE_VINCOLO",nestedMap);
        map.put("CODICE_TITOLO",nestedMap);
        return map;
    }

    private After mockAfter(){
        After after =  new After();
        after.setValue(mockMap());
        return after;
    }

    private ChiaveRapporto chiaveRapportoMock(){
        return ChiaveRapporto.builder()
                .filiale("1")
                .abi("1")
                .servizio("1")
                .categoria("1")
                .codiceRapporto("1")
                .build();
    }


}
