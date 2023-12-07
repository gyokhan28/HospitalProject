import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppointmentSorterTest {
    @Test
    void testFormatHour() {
        //GIVEN
        int hour = 1630;

        //WHEN
        String actualResult = AppointmentSorter.formatHour(hour);

        //THEN
        String expectedResult = "16:30";

        Assertions.assertEquals(expectedResult, actualResult);
    }

}
