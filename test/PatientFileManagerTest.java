import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientFileManagerTest {
    @Test
    void checkLoadMethodWhenGiveWrongList() throws IOException {
        //GIVEN
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient(1, "Maria", "Petrova", 25));
        patientList.add(new Patient(2, "Ivan", "Ivanov", 34));
        patientList.add(new Patient(3, "Konstantin", "Marinov", 34));
        //WHEN
        List<Patient> patientListFromFile = PatientFileManager.loadPatients("Patients.csv");

        //THEN
        Assertions.assertNotEquals(patientListFromFile, patientList);
    }

    @Test
    void checkLoadMethodWhenGiveCorrectList() throws IOException {
        //GIVEN
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient(1, "Maria", "Petrova", 25));
        patientList.add(new Patient(2, "Ivan", "Ivanov", 34));
        patientList.add(new Patient(3, "Konstantin", "Marinov", 18));
        patientList.add(new Patient(4, "Krasimira", "Petkova", 4));
        patientList.add(new Patient(5, "Milen", "Georgiev", 10));
        patientList.add(new Patient(6, "Kamen", "Vladimirov", 15));
        patientList.add(new Patient(7, "Hristo", "Hristov", 23));
        patientList.add(new Patient(8, "Ivan", "Grigorov", 29));
        patientList.add(new Patient(9, "Radostin", "Trifonov", 21));
        patientList.add(new Patient(10, "Milen", "Dobrev", 40));
        //WHEN
        List<Patient> patientListFromFile = PatientFileManager.loadPatients("Patients.csv");

        //THEN
        System.out.println("Expected: " + patientList);
        System.out.println("Actual: " + patientListFromFile);
        Assertions.assertEquals(patientListFromFile, patientList);
    }
    @Test
    void checkBySizeLoadMethodWhenGiveCorrectList() throws IOException {
        //GIVEN
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient(1, "Maria", "Petrova", 25));
        patientList.add(new Patient(2, "Ivan", "Ivanov", 34));
        patientList.add(new Patient(3, "Konstantin", "Marinov", 18));
        patientList.add(new Patient(4, "Krasimira", "Petkova", 4));
        patientList.add(new Patient(5, "Milen", "Georgiev", 10));
        patientList.add(new Patient(6, "Kamen", "Vladimirov", 15));
        patientList.add(new Patient(7, "Hristo", "Hristov", 23));
        patientList.add(new Patient(8, "Ivan", "Grigorov", 29));
        patientList.add(new Patient(9, "Radostin", "Trifonov", 21));
        patientList.add(new Patient(10, "Milen", "Dobrev", 40));
        //WHEN
        List<Patient> patientListFromFile = PatientFileManager.loadPatients("Patients.csv");

        //THEN
        System.out.println("Expected: " + patientList);
        System.out.println("Actual: " + patientListFromFile);
        Assertions.assertEquals(patientListFromFile.size(), patientList.size());
    }
    @Test
    void checkWriteMethod() throws IOException {
        //GIVEN
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient(1, "Maria", "Petrova", 25));
        patientList.add(new Patient(2, "Ivan", "Ivanov", 34));
        patientList.add(new Patient(3, "Konstantin", "Marinov", 34));

        //WHEN
        PatientFileManager.writePatient(patientList,"Patients For Test.csv");
        List<Patient> patientListFromFile = PatientFileManager.loadPatients("Patients For Test.csv");

        //THEN
        Assertions.assertEquals(patientListFromFile,patientList);
    }
    @Test
    void checkWriteMethodBySize() throws IOException {
        //GIVEN
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient(1, "Maria", "Petrova", 25));
        patientList.add(new Patient(2, "Ivan", "Ivanov", 34));
        patientList.add(new Patient(3, "Konstantin", "Marinov", 34));

        //WHEN
        PatientFileManager.writePatient(patientList, "Patients For Test2.csv");
        List<Patient> patientListFromFile = PatientFileManager.loadPatients("Patients For Test2.csv");

        //THEN
        Assertions.assertEquals(patientListFromFile.size(),patientList.size());
    }
    @Test
    void checkLoadMethod() throws IOException {
        //GIVEN

        //WHEN
        List<Patient> patientListFromFile = PatientFileManager.loadPatients("Patients For Test2.csv");

        //THEN
        Assertions.assertNotNull(patientListFromFile);
    }
}
