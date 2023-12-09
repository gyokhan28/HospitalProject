import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class ChangeDataTimeTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<Doctor> doctorListFromFile;
    List<Appointment> appointmentListFromFile;
    Doctor doctor;
    Patient patient;


    @BeforeEach
    void setuop() throws IOException {
        Setup.loadLists();
        System.setOut(new PrintStream(outContent));
        doctor = new Doctor();
        patient = new Patient();
        doctorListFromFile = DoctorFileManager.loadDoctors("Doctors For Test.csv");
        appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test.csv");
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void appointmentAlreadyExists() {
        //GIVEN
        Appointment appointment = new Appointment(1, patient, "initial", "15-03-2023", 1030, doctor);

        //WHEN
        boolean extend = ChangeDateTime.appointmentAlreadyExists(appointment);
        //THEN
        Assertions.assertFalse(extend);
    }

    @Test
    void checkIfTheIDIsCorrect() {
        //GIVEN
        ChangeDateTime changeDateTime = new ChangeDateTime();
        //WHEN
        boolean extend = changeDateTime.checkIfTheIDIsCorrect(1, 7);
        //THEN
        Assertions.assertTrue(extend);
    }

}
