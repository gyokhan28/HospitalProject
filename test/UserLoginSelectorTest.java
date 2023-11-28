import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserLoginSelectorTest {
    private LoginDoctor loginDoctor;
    private List<Doctor> doctorList;
    @BeforeEach
    void setUp() throws IOException {
        doctorList = new ArrayList<>();
        Doctor testDoctor = new Doctor(1, "John", "Doe", "Anesthesiology");
        doctorList.add(testDoctor);
        loginDoctor = new LoginDoctor();
    }

    @Test
    void whenGive1MustCreateLoginDoctor() throws IOException {
        //GIVE
        String input = "1\nJohn\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserLoginSelector userLoginSelector = new UserLoginSelector();

        //WHEN
        userLoginSelector.showSelector();
        System.setIn(System.in);
        System.setOut(System.out);
        //THEN


        String expectedOutput = "Verification successful"; // Заменете с очаквания резултат
        assertEquals(expectedOutput.trim(), outContent.toString().trim());

    }

}
