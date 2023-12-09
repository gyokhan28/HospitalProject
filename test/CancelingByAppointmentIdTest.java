import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CancelingByAppointmentIdTest {
    @BeforeEach
    void setup() throws IOException {
        Setup.loadLists();
    }
    @Test
    void whenGiveCorrectValues(){
        //GIVEN

        //WHEN
        boolean expected = CancelingByAppointmentId.checkIfTheIDIsCorrect(1,7);
        //THEn
        Assertions.assertTrue(expected);
    }
    @Test
    void whenGiveInCorrectValues(){
        //GIVEN

        //WHEN
        boolean expected = CancelingByAppointmentId.checkIfTheIDIsCorrect(2,7);
        //THEn
        Assertions.assertFalse(expected);
    }
}
