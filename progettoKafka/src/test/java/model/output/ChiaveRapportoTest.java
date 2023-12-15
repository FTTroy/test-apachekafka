package model.output;

import com.github.FTTroy.model.output.ChiaveRapporto;
import org.junit.jupiter.api.Test;

public class ChiaveRapportoTest {

    @Test
    public void testGetterSetter(){
        ChiaveRapporto chiaveRapporto = ChiaveRapporto.builder()
                .abi("TEST")
                .servizio("TEST")
                .categoria("TEST")
                .filiale("TEST")
                .codiceRapporto("TEST")
                .codiceSottorapporto("TEST")
                .build();
        chiaveRapporto.setAbi("");
        chiaveRapporto.setServizio("");
        chiaveRapporto.setCategoria("");
        chiaveRapporto.setFiliale("");
        chiaveRapporto.setCodiceRapporto("");
        chiaveRapporto.setCodiceSottorapporto("");
        String abi = chiaveRapporto.getAbi();
        String servizio = chiaveRapporto.getServizio();
        String categoria = chiaveRapporto.getCategoria();
        String filiale = chiaveRapporto.getFiliale();
        String codiceRapporto = chiaveRapporto.getCodiceRapporto();
        String codiceSottorapporto = chiaveRapporto.getCodiceSottorapporto();
    }
}
