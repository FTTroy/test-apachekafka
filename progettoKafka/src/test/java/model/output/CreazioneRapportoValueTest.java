package model.output;

import com.github.FTTroy.model.output.ChiaveRapporto;
import com.github.FTTroy.model.output.CreazioneRapportoValue;
import com.github.FTTroy.model.output.Intestatario;
import com.github.FTTroy.model.output.Testata;
import org.junit.jupiter.api.Test;


public class CreazioneRapportoValueTest {

    @Test
    public void testGetterSetter(){

        CreazioneRapportoValue creazioneRapportoValue = CreazioneRapportoValue.builder()
                .chiaveRapporto(chiaveRapportoMock())
                .testata(testataMock())
                .intestatario(intestatarioMock())
                .codiceTitolo("TEST")
                .durata("TEST")
                .dataInizioVincolo("TEST")
                .dataFineVincolo("TEST")
                .saldoContabile("TEST")
                .build();

        creazioneRapportoValue.setTestata(testataMock());
        creazioneRapportoValue.setChiaveRapporto(chiaveRapportoMock());
        creazioneRapportoValue.setIntestatario(intestatarioMock());
        creazioneRapportoValue.setSaldoContabile("");
        creazioneRapportoValue.setDurata("");
        creazioneRapportoValue.setDataInizioVincolo("");
        creazioneRapportoValue.setDataFineVincolo("");
        creazioneRapportoValue.setCodiceTitolo("");

        Testata testata = creazioneRapportoValue.getTestata();
        ChiaveRapporto chiaveRapporto = creazioneRapportoValue.getChiaveRapporto();
        Intestatario intestatario = creazioneRapportoValue.getIntestatario();
        String saldoContabile = creazioneRapportoValue.getSaldoContabile();
        String durata = creazioneRapportoValue.getDurata();
        String dataInizioVincolo = creazioneRapportoValue.getDataInizioVincolo();
        String dataFineVincolo = creazioneRapportoValue.getDataFineVincolo();
        String codiceTitolo = creazioneRapportoValue.getCodiceTitolo();


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
