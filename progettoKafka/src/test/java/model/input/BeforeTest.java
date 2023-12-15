package model.input;

import com.github.FTTroy.model.input.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BeforeTest {

    @Test
    public void testGetterSetter(){
        Before before = new Before();
        before.setValue(new HashMap<>());
        before.getValue();
    }
}
