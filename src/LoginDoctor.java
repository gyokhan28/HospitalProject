import java.io.IOException;
import java.util.List;

public class LoginDoctor {
    DoctorFileManager doctorFileManager;
    protected List<Doctor> doctorList;
    Verifier verifier;

    public LoginDoctor() throws IOException {
        doctorList = DoctorFileManager.loadDoctors("Doctors.csv");
        verifier = new Verifier();
    }

    protected void verifyUserIdentity() throws IOException {
        int id = verifier.getIdFromUser();
        String name = verifier.getNameFromUser();
        boolean isFound = false;
        for (Doctor doctor : doctorList) {
            if (id == doctor.getId() && name.equalsIgnoreCase(doctor.getFirstName())) {
                isFound = true;
                DoctorMenu doctorMenu = new DoctorMenu(doctor.getId(), doctor.getFirstName(), doctor.getLastName(), doctorList);
                doctorMenu.showMenu();
            }
        }
        if (!isFound) {
            System.out.println("Incorrect ID/Name! Try again:");
            verifyUserIdentity();
        }
    }
}
