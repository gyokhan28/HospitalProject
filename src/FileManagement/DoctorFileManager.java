package FileManagement;

import Doctor.Doctor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Doctor.Specialities;

public class DoctorFileManager {

    public static List<Doctor> loadDoctors(String fileName) throws IOException {
        List<Doctor> doctorList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            doctorList.add(new Doctor(Integer.parseInt(info[0]), info[1], info[2], Specialities.valueOf(info[3])));
        }
        return doctorList;
    }
    public static void writeDoctors(List<Doctor> doctors, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Doctor doctor : doctors) {
            bufferedWriter.write(doctor.getId() + "," + doctor.getFirstName() + "," + doctor.getLastName() + "," + doctor.getSpeciality());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
    }
}
