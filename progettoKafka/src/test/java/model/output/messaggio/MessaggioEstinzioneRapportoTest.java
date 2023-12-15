package model.output.messaggio;


import com.github.FTTroy.model.output.ChiaveRapporto;
import com.github.FTTroy.model.output.EstinzioneRapportoValue;
import com.github.FTTroy.model.output.Testata;
import com.github.FTTroy.model.output.messaggio.MessaggioEstinzioneRapporto;
import org.junit.jupiter.api.Test;

public class MessaggioEstinzioneRapportoTest {

    @Test
    public void testGetterSetter() {
        MessaggioEstinzioneRapporto messaggioEstinzioneRapporto = MessaggioEstinzioneRapporto.builder()
                .value(estinzioneRapportoValueMock())
                .build();
        messaggioEstinzioneRapporto.setValue(estinzioneRapportoValueMock());
        EstinzioneRapportoValue value = messaggioEstinzioneRapporto.getValue();


    }

    private EstinzioneRapportoValue estinzioneRapportoValueMock() {
        return EstinzioneRapportoValue.builder()
                .chiaveRapporto(chiaveRapportoMock())
                .testata(testataMock())
                .build();
    }

    private ChiaveRapporto chiaveRapportoMock() {
        return ChiaveRapporto.builder()
                .abi("TEST")
                .servizio("TEST")
                .categoria("TEST")
                .filiale("TEST")
                .codiceRapporto("TEST")
                .codiceSottorapporto("TEST")
                .build();
    }

    private Testata testataMock() {
        return Testata.builder()
                .idCorrelazione("TEST")
                .tipoEvento("TEST")
                .idEvento("TEST")
                .origine("TEST")
                .timestamp("TEST")
                .build();
    }
}
