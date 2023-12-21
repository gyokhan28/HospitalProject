import Appointment.Appointment;
import FileManagement.AppointmentsFileManager;
import Main.Setup;
import Patient.PreviewOfRecordedHours;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class PreviewOfRecordedHoursTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<Appointment> appointmentListFromFile;

    @BeforeEach
    public void setup() throws IOException {
        Setup.loadLists();
        System.setOut(new PrintStream(outContent));
        appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test.csv");

    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void whenGivenPatientIDIsInAppointmentList() {
        //GIVEN
        int id = 7;

        //WHEN
        PreviewOfRecordedHours.showRecordedHours(id);
        //THEN
        String exception = "Appointment ID: 1 Type of examination: Initial Date: 15-03-2023 Time: 1030 Doctor ID: 12";
        Assertions.assertEquals(exception.trim(), outContent.toString().trim());
    }

    @Test
    public void whenGivenPatientIDIsNotInAppointmentList() {
        //GIVEN
        int id = 6;

        //WHEN
        PreviewOfRecordedHours.showRecordedHours(id);
        //THEN
        String exception = "You don't have any doctor appointments";
        Assertions.assertEquals(exception.trim(), outContent.toString().trim());
    }
}