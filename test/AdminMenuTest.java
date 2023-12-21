import Admin.AdminMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class AdminMenuTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() throws IOException {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void showMenuTest() throws IOException {
        //GIVEN
        //WHEN
        AdminMenu.showMenu();
        //THEN
        String exception = "1. Add new doctor\n2. Add new patient\n0. Exit";
        Assertions.assertEquals(exception.trim(), outContent.toString().trim());
    }
}
