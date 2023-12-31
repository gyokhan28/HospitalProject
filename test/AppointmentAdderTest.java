import Appointment.AppointmentAdder;
import Main.Setup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AppointmentAdderTest {
    @Test
    void checkMethodForReturningLastID() throws IOException {
        //GIVEN
        Setup.loadLists();

        //WHEN
        int actual = AppointmentAdder.returnLastID();

        //THEN
        int expected = 8;
        Assertions.assertEquals(expected, actual);
    }
}
