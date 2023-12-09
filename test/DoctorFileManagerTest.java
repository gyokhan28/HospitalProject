import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class DoctorFileManagerTest {
    List<Doctor> doctorListFromFile;

    @BeforeEach
    void setup() throws IOException {
        Setup.loadLists();
        doctorListFromFile = DoctorFileManager.loadDoctors("Doctors For Test.csv");
    }

    @Test
    void testIfDoctorsAreLoaded() {
        //GIVEN
        int expectedSizeOfList = 12;

        //WHEN
        int actualSizeOfList = doctorListFromFile.size();

        //THEN
        Assertions.assertEquals(expectedSizeOfList, actualSizeOfList);
    }

    @Test
    void testIfDoctorsAreLoadedWithCorrectInformation() {
        //GIVEN
        Doctor testDoctor = new Doctor(3, "Georgi", "Hristov", Specialities.GASTROENTEROLOGY);

        //WHEN
        Doctor actualDoctor = doctorListFromFile.get(2);

        //THEN
        Assertions.assertEquals(testDoctor.getId(), actualDoctor.getId());
    }

    @Test
    void testIfWriteMethodWorksCorrectly() throws IOException {
        //GIVEN
        Doctor newDoctor = new Doctor(100, "Test", "Test", Specialities.CARDIOLOGY);

        //WHEN
        doctorListFromFile.add(newDoctor);
        int newSize = doctorListFromFile.size();
        DoctorFileManager.writeDoctors(doctorListFromFile, "Doctors For Test 2.csv");

        //THEN
        int expectedSize = 13;
        Assertions.assertEquals(newSize, expectedSize);
        doctorListFromFile.remove(newDoctor);
        DoctorFileManager.writeDoctors(doctorListFromFile, "Doctors For Test 2.csv");
    }

}
