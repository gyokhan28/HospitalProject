import Main.Setup;
import Login.LoginPatient;
import Patient.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
