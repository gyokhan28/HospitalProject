import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AppointmentAdderTest {
    @Test
    void checkMethodForReturningLastID() throws IOException {
        //GIVEN


        //WHEN
        int expected = AppointmentAdder.returnLastID();

        //THEN
        int actual =8;
        Assertions.assertEquals(expected,actual);
    }
}
