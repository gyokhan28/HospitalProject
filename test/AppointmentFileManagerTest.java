import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileManagerTest {
    @Test
    void checkLoadMethodWhenGiveWrongList() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, 7, "initial", "15-03-2023", 1030, 12));
        appointments.add(new Appointment(2, 5, "consultation", "18 - 04 - 2023", 1520, 3));
        appointments.add(new Appointment(3, 4, "secondary", "15 - 05 - 2023", 1230, 8));
        appointments.add(new Appointment(4, 3, "initial", "15 - 05 - 2023", 1515, 5));
        //WHEN
        List<Appointment> appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments.csv");

        //THEN
        Assertions.assertNotEquals(appointments, appointmentListFromFile);
    }

    @Test
    void checkLoadMethodWhenGiveCorrectList() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, 7, "initial", "15 - 03 - 2023", 1030, 12));
        appointments.add(new Appointment(2, 5, "consultation", "18 - 04 - 2023", 1520, 3));
        appointments.add(new Appointment(3, 4, "secondary", "15 - 05 - 2023", 1230, 8));
        appointments.add(new Appointment(4, 3, "initial", "15 - 05 - 2023", 1515, 5));
        appointments.add(new Appointment(5, 2, "consultation", "13 - 05 - 2023", 1610, 1));
        appointments.add(new Appointment(6, 10, "secondary", "23 - 05 - 2023", 1120, 2));
        appointments.add(new Appointment(7, 1, "consultation", "14 - 05 - 2023", 1310, 12));
        appointments.add(new Appointment(8, 8, "secondary", "13 - 01 - 2023", 1525, 3));
        //WHEN
        List<Appointment> appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments.csv");

        //THEN
        System.out.println("Expected: " + appointments);
        System.out.println("Actual: " + appointmentListFromFile);
        Assertions.assertEquals(appointmentListFromFile, appointments);
    }

    @Test
    void checkBySizeLoadMethodWhenGiveCorrectList() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, 7, "initial", "15 - 03 - 2023", 1030, 12));
        appointments.add(new Appointment(2, 5, "consultation", "18 - 04 - 2023", 1520, 3));
        appointments.add(new Appointment(3, 4, "secondary", "15 - 05 - 2023", 1230, 8));
        appointments.add(new Appointment(4, 3, "initial", "15 - 05 - 2023", 1515, 5));
        appointments.add(new Appointment(5, 2, "consultation", "13 - 05 - 2023", 1610, 1));
        appointments.add(new Appointment(6, 10, "secondary", "23 - 05 - 2023", 1120, 2));
        appointments.add(new Appointment(7, 1, "consultation", "14 - 05 - 2023", 1310, 12));
        appointments.add(new Appointment(8, 8, "secondary", "13 - 01 - 2023", 1525, 3));
        //WHEN
        List<Appointment> appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments.csv");

        //THEN
        System.out.println("Expected: " + appointments);
        System.out.println("Actual: " + appointmentListFromFile);
        Assertions.assertEquals(appointmentListFromFile.size(), appointments.size());
    }

    @Test
    void checkWriteMethod() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, 7, "initial", "15 - 03 - 2023", 1030, 12));
        appointments.add(new Appointment(2, 5, "consultation", "18 - 04 - 2023", 1520, 3));
        appointments.add(new Appointment(3, 4, "secondary", "15 - 05 - 2023", 1230, 8));

        //WHEN
        AppointmentsFileManager.writeAppointments(appointments,"Appointments For Test.csv");
        List<Appointment> appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test.csv");

        //THEN
        Assertions.assertEquals(appointmentListFromFile, appointments);
    }

    @Test
    void checkWriteMethodBySize() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, 7, "initial", "15 - 03 - 2023", 1030, 12));
        appointments.add(new Appointment(2, 5, "consultation", "18 - 04 - 2023", 1520, 3));
        appointments.add(new Appointment(3, 4, "secondary", "15 - 05 - 2023", 1230, 8));

        //WHEN
        AppointmentsFileManager.writeAppointments(appointments, "Appointments For Test 2.csv");
        List<Appointment> appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test 2.csv");

        //THEN
        Assertions.assertEquals(appointmentListFromFile.size(), appointments.size());
    }
    @Test
    void checkLoadMethod() throws IOException {
        //GIVEN

        //WHEN
        List<Appointment> appointments = AppointmentsFileManager.loadAppointments("Appointments For Test 2.csv");

        //THEN
        Assertions.assertNotNull(appointments);
    }
}