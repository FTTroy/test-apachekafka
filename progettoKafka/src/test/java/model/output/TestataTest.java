package model.output;

import com.github.FTTroy.model.output.Testata;
import org.junit.jupiter.api.Test;

public class TestataTest {

    @Test
    public void testGetterSetter() {

        Testata testata = Testata.builder()
                .idCorrelazione("TEST")
                .tipoEvento("TEST")
                .idEvento("TEST")
                .origine("TEST")
                .timestamp("TEST")
                .build();
        testata.setTimestamp("");
        testata.setOrigine("");
        testata.setIdEvento("");
        testata.setTipoEvento("");
        testata.setIdCorrelazione("");

        String timestamp = testata.getTimestamp();
        String origine = testata.getOrigine();
        String idEvento = testata.getIdEvento();
        String tipoEvento = testata.getTipoEvento();
        String idCorrelazione = testata.getIdCorrelazione();


    }
}
