package model.output;

import com.github.FTTroy.model.output.Intestatario;
import org.junit.jupiter.api.Test;

public class IntestatarioTest {

    @Test
    public void testGetterSetter(){
        Intestatario intestatario = Intestatario.builder()
                .ndg("TEST")
                .abi("TEST")
                .build();

        intestatario.setAbi("");
        intestatario.setNdg("");
        String abi = intestatario.getAbi();
        String ndg = intestatario.getNdg();


    }
}
