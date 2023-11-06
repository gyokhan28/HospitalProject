import java.io.IOException;
import java.util.List;

public interface DoctorLoader {
    public List<Doctor> loadDoctors(String fileName) throws IOException;

}
