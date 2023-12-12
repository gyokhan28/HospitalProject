import Main.Setup;
import Doctor.Doctor;
import Login.LoginDoctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoginDoctorTest {
    @BeforeEach
    public void setup() throws IOException {
        Setup.loadLists();
    }

    @Test
    public void testReturnDoctorByGivenId() {
        //GIVEN
        int id = 3;

        //WHEN
        Doctor doctor = LoginDoctor.returnDoctor(id);

        //THEN
        Doctor expectedDoctor = Setup.getDoctorList().get(id - 1);
        Assertions.assertEquals(doctor, expectedDoctor);
    }

}
