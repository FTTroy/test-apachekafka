package com.github.FTTroy.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.uuid.Generators;
import com.github.FTTroy.model.output.*;
import com.github.FTTroy.model.output.messaggio.MessaggioCreazioneRapporto;
import com.github.FTTroy.model.output.messaggio.MessaggioEstinzioneRapporto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class EntityMapper {
    public Object populateValue(JsonNode node, String tipoEvento) {
        Testata testata = testataMapper(node, tipoEvento);
        ChiaveRapporto chiaveRapporto = chiaveRapportoMapper(node);

        if (tipoEvento.equals("RAPPORTO_CREATO")) {
            Intestatario intestatario = intestatarioMapper(node);
            String saldoContabile = node.findValue("SALDO_CONTABILE").fields().next().getValue().asText();
            String durata = node.findValue("DURATA").fields().next().getValue().asText();
            String dataInizioVincolo = node.findValue("DATA_INIZIO_VINCOLO").fields().next().getValue().asText();
            String dataFineVincolo = node.findValue("DATA_FINE_VINCOLO").fields().next().getValue().asText();
            String codiceTitolo = node.findValue("CODICE_TITOLO").fields().next().getValue().asText();

            CreazioneRapportoValue creazioneValue = CreazioneRapportoValue.builder()
                    .testata(testata)
                    .chiaveRapporto(chiaveRapporto)
                    .intestatario(intestatario)
                    .saldoContabile(saldoContabile)
                    .durata(durata)
                    .dataInizioVincolo(dataInizioVincolo)
                    .dataFineVincolo(dataFineVincolo)
                    .codiceTitolo(codiceTitolo)
                    .build();

            return MessaggioCreazioneRapporto.builder().value(
                        CreazioneRapportoValue.builder()
                            .testata(testata)
                            .chiaveRapporto(chiaveRapporto)
                            .intestatario(intestatario)
                            .saldoContabile(saldoContabile)
                            .durata(durata)
                            .dataInizioVincolo(dataInizioVincolo)
                            .dataFineVincolo(dataFineVincolo)
                            .codiceTitolo(codiceTitolo)
                            .build())
                    .build();

        } else {
            EstinzioneRapportoValue estinzioneValue = EstinzioneRapportoValue.builder()
                    .testata(testata)
                    .chiaveRapporto(chiaveRapporto)
                    .build();

            return MessaggioEstinzioneRapporto.builder()
                    .value(estinzioneValue)
                    .build();
        }
    }

    private Testata testataMapper(JsonNode node, String tipoEvento) {
        String idEvento = String.valueOf(Generators.timeBasedGenerator().generate());
        String idCorrelazione = String.valueOf(Generators.timeBasedGenerator().generate());
        Testata testata = Testata.builder().timestamp(String.valueOf(Timestamp.valueOf(LocalDateTime.now()))).
                origine("be-certposizionecliente").idEvento(idEvento).tipoEvento(tipoEvento).idCorrelazione(idCorrelazione).build();
        return testata;
    }

    public ChiaveRapporto chiaveRapportoMapper(JsonNode node) {
        String abi = node.findValue("ABI").fields().next().getValue().asText();
        String servizio = node.findValue("SERVIZIO").fields().next().getValue().asText();
        String categoria = node.findValue("CATEGORIA").fields().next().getValue().asText();
        String filiale = node.findValue("FILIALE").fields().next().getValue().asText();
        String codiceRapporto = node.findValue("CODICE_RAPPORTO").fields().next().getValue().asText();
        String codiceSottorapporto = node.findValue("CODICE_SOTTORAPPORTO") != null ?
                node.findValue("CODICE_SOTTORAPPORTO").fields().next().getValue().asText() : null;

        ChiaveRapporto chiaveRapporto = ChiaveRapporto.builder()
                .abi(abi)
                .servizio(servizio)
                .categoria(categoria)
                .filiale(filiale)
                .codiceRapporto(codiceRapporto)
                .codiceSottorapporto(codiceSottorapporto)
                .build();
        return chiaveRapporto;
    }

    private Intestatario intestatarioMapper(JsonNode node) {
        String abi = node.findValue("ABI").fields().next().getValue().asText();
        String ndg = node.findValue("NDG").fields().next().getValue().asText();
        Intestatario intestatario = Intestatario.builder().abi(abi).ndg(ndg).build();
        return intestatario;
    }

    public String generateKey(ChiaveRapporto chiaveRapporto){
        StringJoiner joiner = new StringJoiner(".");
       return String.valueOf(joiner.add(chiaveRapporto.getAbi())
                .add(chiaveRapporto.getServizio())
                .add(chiaveRapporto.getCategoria())
                .add(chiaveRapporto.getFiliale())
                .add(chiaveRapporto.getCodiceRapporto()));
    }
}
