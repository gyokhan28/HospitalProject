import Appointment.Appointment;
import FileManagement.AppointmentsFileManager;
import Main.Setup;
import Doctor.Doctor;
import Doctor.Specialities;
import Patient.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileManagerTest {

    List<Appointment> appointmentListFromFile;
    @BeforeEach
    public void setup() throws IOException {
        Setup.loadLists();
        appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test.csv");
    }

    Doctor doctor1 = new Doctor(1, "Stoyan", "Kamenov", Specialities.ANESTHESIOLOGY);
    Doctor doctor2 = new Doctor(2, "Ivaylo", "Petrov", Specialities.INTERNAL_DISEASES);
    Doctor doctor3 = new Doctor(3, "Georgi", "Hristov", Specialities.GASTROENTEROLOGY);
    Doctor doctor4 = new Doctor(4, "Vlado", "Borisov", Specialities.ENDOCRINOLOGY);
    Doctor doctor5 = new Doctor(5, "Vlado", "Nikolov", Specialities.CARDIOLOGY);
    Doctor doctor6 = new Doctor(6, "Boris", "Jorov", Specialities.DERMATOLOGY);
    Doctor doctor7 = new Doctor(7, "Trayan", "Marinov", Specialities.NEUROLOGY);
    Doctor doctor8 = new Doctor(8, "Gospodin", "Radoslavov", Specialities.RHEUMATOLOGY);
    Doctor doctor9 = new Doctor(9, "Nikola", "Rosenov", Specialities.ENDOCRINOLOGY);
    Doctor doctor10 = new Doctor(10, "Borislav", "Marchev", Specialities.CARDIOLOGY);
    Doctor doctor11 = new Doctor(11, "Deyan", "Dobrev", Specialities.DERMATOLOGY);
    Doctor doctor12 = new Doctor(12, "Ivan", "Ivanov", Specialities.INTERNAL_DISEASES);
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
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, doctor1));
        appointments.add(new Appointment(2, patient5, "consultation", "18-04-2023", 1520, doctor2));
        appointments.add(new Appointment(3, patient4, "secondary", "15-05-2023", 1230, doctor3));
        appointments.add(new Appointment(4, patient3, "initial", "15-05-2023", 1515, doctor4));

        //WHEN
        appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test.csv");


        //THEN
        Assertions.assertNotEquals(appointments, appointmentListFromFile);
    }

    @Test
    void checkLoadMethodWhenGiveCorrectList() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, doctor12));
        appointments.add(new Appointment(2, patient5, "consultation", "18-04-2023", 1520, doctor3));
        appointments.add(new Appointment(3, patient4, "secondary", "15-05-2023", 1230, doctor8));
        appointments.add(new Appointment(4, patient3, "initial", "15-05-2023", 1515, doctor5));
        appointments.add(new Appointment(5, patient2, "consultation", "13-05-2023", 1610, doctor1));
        appointments.add(new Appointment(6, patient10, "secondary", "21-05-2023", 1120, doctor2));
        appointments.add(new Appointment(7, patient1, "consultation", "14-05-2023", 1310, doctor12));
        appointments.add(new Appointment(8, patient8, "secondary", "13-01-2023", 1525, doctor3));

        //WHEN

        //THEN
        Assertions.assertEquals(appointmentListFromFile, appointments);
    }

    @Test
    void checkWriteMethod() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, doctor12));
        appointments.add(new Appointment(2, patient5, "consultation", "18-04-2023", 1520, doctor3));
        appointments.add(new Appointment(3, patient4, "secondary", "15-05-2023", 1230, doctor8));

        //WHEN
        AppointmentsFileManager.writeAppointments(appointments, "Appointments For Test 2.csv");
        appointmentListFromFile = AppointmentsFileManager.loadAppointments("Appointments For Test 2.csv");

        //THEN
        Assertions.assertEquals(appointmentListFromFile, appointments);
    }

    @Test
    void checkWriteMethodBySize() throws IOException {
        //GIVEN
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, patient7, "initial", "15-03-2023", 1030, doctor12));
        appointments.add(new Appointment(2, patient5, "consultation", "18-04-2023", 1520, doctor3));
        appointments.add(new Appointment(3, patient4, "secondary", "15-05-2023", 1230, doctor8));

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