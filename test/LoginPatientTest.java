import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class LoginPatientTest {
    @BeforeEach
    public void setup() throws IOException {
        Setup.loadLists();
    }

    @Test
    public void testReturnPatientByGivenId(){
        //GIVEN
        int id = 3;

        //WHEN
        Patient patient = LoginPatient.returnPatient(id);

        //THEN
        Patient expectedPatient = Setup.getPatientList().get(id-1);
        Assertions.assertEquals(patient,expectedPatient);
    }

}
