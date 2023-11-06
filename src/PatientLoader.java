import java.io.IOException;
import java.util.List;

public interface PatientLoader {
    public List<Patient> loadPatients(String fileName) throws IOException;

}
