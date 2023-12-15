package model.output;

import com.github.FTTroy.model.output.ChiaveRapporto;
import com.github.FTTroy.model.output.EstinzioneRapportoValue;
import com.github.FTTroy.model.output.Testata;
import org.junit.jupiter.api.Test;

public class EstinzioneRapportoValueTest {



    @Test
    public void testGetterSetter(){
        EstinzioneRapportoValue estinzioneRapportoValue = EstinzioneRapportoValue.builder()
                .chiaveRapporto(chiaveRapportoMock())
                .testata(testataMock())
                .build();
        estinzioneRapportoValue.setTestata(testataMock());
        estinzioneRapportoValue.setChiaveRapporto(chiaveRapportoMock());
        Testata testata = estinzioneRapportoValue.getTestata();
        ChiaveRapporto chiaveRapporto = estinzioneRapportoValue.getChiaveRapporto();


    }

    private ChiaveRapporto chiaveRapportoMock(){
        ChiaveRapporto chiaveRapporto = ChiaveRapporto.builder()
                .abi("TEST")
                .servizio("TEST")
                .categoria("TEST")
                .filiale("TEST")
                .codiceRapporto("TEST")
                .codiceSottorapporto("TEST")
                .build();
        return chiaveRapporto;
    }

    private Testata testataMock(){
        Testata testata = Testata.builder()
                .idCorrelazione("TEST")
                .tipoEvento("TEST")
                .idEvento("TEST")
                .origine("TEST")
                .timestamp("TEST")
                .build();
        return testata;
    }


}
