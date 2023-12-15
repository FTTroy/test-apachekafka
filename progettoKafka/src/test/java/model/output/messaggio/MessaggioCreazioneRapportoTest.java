package model.output.messaggio;

import com.github.FTTroy.model.output.ChiaveRapporto;
import com.github.FTTroy.model.output.CreazioneRapportoValue;
import com.github.FTTroy.model.output.Intestatario;
import com.github.FTTroy.model.output.Testata;
import com.github.FTTroy.model.output.messaggio.MessaggioCreazioneRapporto;
import org.junit.jupiter.api.Test;

public class MessaggioCreazioneRapportoTest {

    @Test
    public void testGetterSetter() {
        MessaggioCreazioneRapporto messaggioCreazioneRapporto = MessaggioCreazioneRapporto.builder()
                .value(creazioneRapportoValueMock()).build();

        messaggioCreazioneRapporto.setValue(creazioneRapportoValueMock());
        CreazioneRapportoValue value = messaggioCreazioneRapporto.getValue();
            }

    private CreazioneRapportoValue creazioneRapportoValueMock(){

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


