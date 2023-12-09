import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class AppointmentDisplayerTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<Doctor>doctorListFromFile;
    List<Appointment>appointmentListFromFile;


    @BeforeEach
    void setuop() throws IOException {
        Setup.loadLists();
        System.setOut(new PrintStream(outContent));
        doctorListFromFile = DoctorFileManager.loadDoctors("Doctors For Test.csv");
        appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test.csv");
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    void whenGiveCorrectIdOnDoctor(){
        //GIVEN
        int idDoctor = 1;
        AppointmentDisplayer appointmentDisplayer = new AppointmentDisplayer(idDoctor,doctorListFromFile);

        //WHEN
        appointmentDisplayer.showAppointments(1);

        //THEN
        String exception = "App. ID:5, patient: Ivan Ivanov, Ex. type: consultation, Date: 13-05-2023, Time: 1610";
        Assertions.assertEquals(exception.trim(), outContent.toString().trim());

    }
    @Test
    void whenGiveInCorrectIdOnDoctor(){
        //GIVEN
        int idDoctor = 4;
        AppointmentDisplayer appointmentDisplayer = new AppointmentDisplayer(idDoctor,doctorListFromFile);

        //WHEN
        appointmentDisplayer.showAppointments(1);

        //THEN
        String exception = "Showing appointments of Dr.Stoyan Kamenov (ID 1):\nApp. ID:5, patient: Ivan Ivanov, Ex. type: consultation, Date: 13-05-2023, Time: 1610";
        Assertions.assertEquals(exception.trim(), outContent.toString().trim());

    }
}
