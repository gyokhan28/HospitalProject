import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileManagerTest {

    Patient patient1 = new Patient(1, "Maria", "Petrova", 25);
    Patient patient2 = new Patient(2, "Ivan", "Ivanov", 34);
    Patient patient3 = new Patient(3, "Konstantin", "Marinov", 34);
    Patient patient4 = new Patient(4, "Krasimira", "Petkova", 4);
    Patient patient5 = new Patient(5, "Milen", "Georgiev", 10);
    Patient patient6 = new Patient(6, "Kamen", "Vladimirov", 15);
    Patient patient7 = new Patient(7, "Hristo", "Hristov", 23);
    Patient patient8 = new Patient(8, "Ivan", "Grigorov", 29);
    Patient patient9 = new Patient(9, "Radostin", "Trifonov", 21);
    Patient patient10 = new Patient(10, "Milen", "Dobrev", 40);

    @Test
    void checkLoadMethodWhenGivenWrongList() throws IOException {
        //GIVEN
        Setup setup = new Setup();
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, 12));
        appointments.add(new Appointment(2, patient5, "consultation", "18 - 04 - 2023", 1520, 3));
        appointments.add(new Appointment(3, patient4, "secondary", "15 - 05 - 2023", 1230, 8));
        appointments.add(new Appointment(4, patient3, "initial", "15 - 05 - 2023", 1515, 5));
        //WHEN
        List<Appointment> appointmentListFromFile = setup.getAppointmentList();

        //THEN
        Assertions.assertNotEquals(appointments, appointmentListFromFile);
    }

    @Test
    void checkLoadMethodWhenGiveCorrectList() throws IOException {
        //GIVEN
        Setup setup = new Setup();
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, 12));
        appointments.add(new Appointment(2, patient5, "consultation", "18-04-2023", 1520, 3));
        appointments.add(new Appointment(3, patient4, "secondary", "15-05-2023", 1230, 8));
        appointments.add(new Appointment(4, patient3, "initial", "15-05-2023", 1515, 5));
        appointments.add(new Appointment(5, patient2, "consultation", "13-05-2023", 1610, 1));
        appointments.add(new Appointment(6, patient10, "secondary", "23-05-2023", 1120, 2));
        appointments.add(new Appointment(7, patient1, "consultation", "14-05-2023", 1310, 12));
        appointments.add(new Appointment(8, patient8, "secondary", "13-01-2023", 1525, 3));
        //WHEN
        List<Appointment> appointmentListFromFile = setup.getAppointmentList();

        Assertions.assertEquals(appointmentListFromFile, appointments);
    }

    @Test
    void checkWriteMethod() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, 12));
        appointments.add(new Appointment(2, patient5, "consultation", "18-04-2023", 1520, 3));
        appointments.add(new Appointment(3, patient4, "secondary", "15-05-2023", 1230, 8));

        //WHEN
        AppointmentsFileManager.writeAppointments(appointments, "Appointments For Test.csv");
        List<Appointment> appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test.csv");

        //THEN
        Assertions.assertEquals(appointmentListFromFile, appointments);
    }

    @Test
    void checkWriteMethodBySize() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, 12));
        appointments.add(new Appointment(2, patient5, "consultation", "18-04-2023", 1520, 3));
        appointments.add(new Appointment(3, patient4, "secondary", "15-05-2023", 1230, 8));

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

    @Test
    void testMethod() {
        //GIVEN
        List<Appointment> numbers = new ArrayList<>();
        numbers.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, 12));

        List<Appointment> numbers2 = new ArrayList<>();
        numbers2.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, 12));


        Assertions.assertEquals(numbers, numbers2);
    }
}