package model.input;
import com.github.FTTroy.model.input.After;
import com.github.FTTroy.model.input.Before;

import com.github.FTTroy.model.input.InputMessage;
import org.junit.jupiter.api.Test;

public class InputMessageTest {

    @Test
    public void testGetterSetter(){

        InputMessage inputMessage = new InputMessage();
        inputMessage.setBefore(new Before());
        inputMessage.setAfter(new After());
        Before before = inputMessage.getBefore();
        After after = inputMessage.getAfter();
    }
}
