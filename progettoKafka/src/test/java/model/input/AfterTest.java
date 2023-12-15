package model.input;

import com.github.FTTroy.model.input.After;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class AfterTest {

    @Test
    public void testGetterSetter(){
        After after = new After();
        after.setValue(new HashMap<>());
        after.getValue();
    }
}
