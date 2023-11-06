package Doctors;

import Doctors.DoctorLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoctorFileManager implements DoctorLoader {
    @Override
    public List<Doctor> loadDoctors(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<Doctor> doctorList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            doctorList.add(new Doctor(Integer.parseInt(info[0]), info[1], info[2], info[3]));
        }

        return doctorList;
    }
}
